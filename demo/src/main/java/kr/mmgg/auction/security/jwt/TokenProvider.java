package kr.mmgg.auction.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;

import kr.mmgg.auction.login.entity.UserEntity;
import kr.mmgg.auction.login.repository.LoginRepository;
import kr.mmgg.auction.security.jwt.dto.JwtTokenDto;

public class TokenProvider {
	protected static final String AUTHORITIES_KEY = "Authorization";

	protected final String accessTokenSecret;
	protected final long accessTokenValidityInSeconds;

	private static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 3; // 3시간

	protected Key key;

	@Autowired
	private LoginRepository loginRepository;
	
	public TokenProvider(String accessTokenSecret, long accessTokenValidityInSeconds) {
		this.accessTokenSecret = accessTokenSecret;
		/* 5분으로 설정 */
		this.accessTokenValidityInSeconds = accessTokenValidityInSeconds * 1000;

		byte[] keyBytes = Decoders.BASE64.decode(accessTokenSecret);
		this.key = Keys.hmacShaKeyFor(keyBytes); 
	}
	
	public JwtTokenDto createToken(Authentication authentication) {
		String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
		long now = (new Date()).getTime();
		Date validity = new Date(now + this.accessTokenValidityInSeconds);
		Date refreshValidity = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);
		String accessToken = Jwts.builder()
				.setSubject(authentication.getName())
				.claim(AUTHORITIES_KEY, authorities)
				.signWith(key, SignatureAlgorithm.HS512)
				.setExpiration(validity)
				.compact();
		String refreshToken = Jwts.builder()
				.setSubject(authentication.getName())
				.claim(AUTHORITIES_KEY, authorities)
				.signWith(key, SignatureAlgorithm.HS512)
				.setExpiration(refreshValidity)
				.compact();
		//UserEntity userEntity = loginRepository.selectUserForDiscordEmail(authentication.getName());
		return new JwtTokenDto(accessToken, refreshToken, refreshValidity);
	}
	
	public Authentication getAuthentication(String token) {
		Claims claims = Jwts
				.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
		Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		User principal = new User(claims.getSubject(), "", authorities);
		
		return new UsernamePasswordAuthenticationToken(principal, token, authorities);
	}
	
	public JwtTokenDto refreshToken(String refreshTokn) {
		Authentication authentication = getAuthentication(refreshTokn);
		String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
		long now = (new Date()).getTime();
		Date validity = new Date(now + this.accessTokenValidityInSeconds);
		Date refreshValidity = new Date(now + REFRESH_TOKEN_EXPIRE_TIME);
		String accessToken = Jwts.builder()
				.setSubject(authentication.getName())
				.claim(AUTHORITIES_KEY, authorities)
				.signWith(SignatureAlgorithm.HS512, key)
				.setExpiration(validity)
				.compact();
		String refreshToken = Jwts.builder()
				.setSubject(authentication.getName())
				.claim(AUTHORITIES_KEY, authorities)
				.signWith(SignatureAlgorithm.HS512, key)
				.setExpiration(refreshValidity)
				.compact();
		//UserEntity userEntity = loginRepository.selectUserForDiscordEmail(authentication.getName());
		return new JwtTokenDto(accessToken, refreshToken, refreshValidity);
	}
	
	public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            System.out.println("잘못된 JWT 서명입니다.");
        } catch (ExpiredJwtException e) {
        	System.out.println("만료된 JWT 토큰입니다.");
        } catch (UnsupportedJwtException e) {
        	System.out.println("지원되지 않는 JWT 토큰입니다.");
        } catch (IllegalArgumentException e) {
        	System.out.println("JWT 토큰이 잘못되었습니다.");
        }
        return false;
    }
}
