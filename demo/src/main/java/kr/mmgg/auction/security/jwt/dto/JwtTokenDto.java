package kr.mmgg.auction.security.jwt.dto;

import java.util.Date;

import kr.mmgg.auction.login.entity.UserEntity;

public class JwtTokenDto {
	private String discordAccessToken;
	
	private String accessToken;
	private String refreshToken;
	private Date expiresIn;
	
	
	
	public String getDiscordAccessToken() {
		return discordAccessToken;
	}
	public void setDiscordAccessToken(String discordAccessToken) {
		this.discordAccessToken = discordAccessToken;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public Date getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Date expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	public JwtTokenDto(String accessToken, String refreshToken, Date expiresIn) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.expiresIn = expiresIn;
	}
}
