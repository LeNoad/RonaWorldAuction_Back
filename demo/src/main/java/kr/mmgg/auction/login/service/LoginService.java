package kr.mmgg.auction.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.ExpiredJwtException;
import kr.mmgg.auction.login.entity.UserEntity;
import kr.mmgg.auction.login.repository.LoginRepository;
import kr.mmgg.auction.security.jwt.TokenProvider;
import kr.mmgg.auction.security.jwt.dto.JwtTokenDto;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;

	private final TokenProvider tokenProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;

	public LoginService(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder,
			LoginRepository loginRepository) {
		this.tokenProvider = tokenProvider;
		this.authenticationManagerBuilder = authenticationManagerBuilder;
	}

	public JwtTokenDto authentication(UserEntity userEntity) {
		JwtTokenDto jwtTokenDto = null;
		try {
			PreAuthenticatedAuthenticationToken authenticationToken = new PreAuthenticatedAuthenticationToken(userEntity.getDiscordEmail(), userEntity.getDiscordId());
			Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
		    jwtTokenDto = tokenProvider.createToken(authentication);
		} catch (ExpiredJwtException e) {
	        System.out.println("Token expired: " + e.getMessage());
	        // 토큰 재발급 로직
		} catch (AuthenticationException e) {
		    System.out.println("Authentication failed: " + e.getMessage());
		    jwtTokenDto = null;
		} 
		return jwtTokenDto;
	}

	public Integer verifyRegister(Long discordId) {
		return loginRepository.verifyRegister(discordId);
	}

	public UserEntity login(Long discordId) {
		return loginRepository.selectUser(discordId);
	}

	public UserEntity register(UserEntity userEntity) {
		loginRepository.register(userEntity);
		return loginRepository.selectUser(userEntity.getDiscordId());
	}
}
