package kr.mmgg.auction.login.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.mmgg.auction.cmm.ResultDto;
import kr.mmgg.auction.login.entity.DiscordTokenResponse;
import kr.mmgg.auction.login.entity.DiscordUser;
import kr.mmgg.auction.login.entity.UserEntity;
import kr.mmgg.auction.login.repository.LoginRepository;
import kr.mmgg.auction.login.service.LoginService;
import kr.mmgg.auction.security.jwt.TokenProvider;
import kr.mmgg.auction.security.jwt.dto.JwtTokenDto;

@RestController
public class Oauth2Controller {

	@Autowired
	private LoginService loginService;

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private LoginRepository loginRepository;
	
	@Value("${discord.client-id}")
	private String discordClientId;

	@Value("${discord.client-secret}")
	private String discordClientSecret;

	@Value("${discord.redirect-uri}")
	private String discordRedirectUri;

	@Value("${discord.authorization-grant-type}")
	private String discordAuthorizationGrantType;

	/**
	 * 디스코드 리다이렉트
	 */
	@RequestMapping("/oauth/redirect/discord")
	public ResultDto<?> getOauth2Code(@RequestParam("code") String code) throws IOException {
		String accessToken = requestAccessToken(code);
		JwtTokenDto jwtTokenDto = generateJwtToken(accessToken);
		return new ResultDto<>().makeResult(HttpStatus.OK, "JWT 토큰 발행", jwtTokenDto, "info");
	}

	@RequestMapping("/refresh")
	public ResultDto<?> refresh(@RequestParam("refreshToken") String refreshToken) {
		return new ResultDto<>().makeResult(HttpStatus.OK, "JWT 토큰 발행", tokenProvider.refreshToken(refreshToken), "info");
	}
	@RequestMapping("/getUserData")
	public ResultDto<?> getUserData(@RequestParam("discordEmail") String discordEmail) {
		return new ResultDto<>().makeResult(HttpStatus.OK, "test", loginRepository.selectUserForDiscordEmail(discordEmail), "info");
	}

	/* 리다이렉트된 코드를 가지고 accessToken 인증 가져오는 곳 Oauth2 */
	private String requestAccessToken(String code) throws IOException {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setBasicAuth(discordClientId, discordClientSecret);

		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", discordAuthorizationGrantType);
		map.add("code", code);
		map.add("redirect_uri", discordRedirectUri);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		ResponseEntity<String> tokenResponse = restTemplate.postForEntity("https://discord.com/api/v10/oauth2/token",
				entity, String.class);

		String json = tokenResponse.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		DiscordTokenResponse response = objectMapper.readValue(json, DiscordTokenResponse.class);
		return response.getAccess_token();
	}

	/* 계정 정보 인증 과 동시에 JwtToken 발행 */
	private JwtTokenDto generateJwtToken(String accessToken) {
		DiscordUser discordUser = getDiscordUser(accessToken);
		UserEntity user = new UserEntity();
		if (loginService.verifyRegister(discordUser.getId()) != null) {
			user = loginService.login(discordUser.getId());
		} else {
			user.setRonaUnqIdt(123123125L);
			user.setDiscordId(discordUser.getId());
			user.setDiscordGlobalName(discordUser.getGlobal_name());
			user.setDiscordEmail(discordUser.getEmail());
			user = loginService.register(user);
		}
		JwtTokenDto jwtTokenDto = loginService.authentication(user);
		jwtTokenDto.setDiscordAccessToken(accessToken);
		return jwtTokenDto;
	}

	public DiscordUser getDiscordUser(String accessToken) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(accessToken);

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<DiscordUser> userResponse = restTemplate.exchange("https://discord.com/api/v10/users/@me",
				HttpMethod.GET, entity, DiscordUser.class);

		return userResponse.getBody();
	}
}
