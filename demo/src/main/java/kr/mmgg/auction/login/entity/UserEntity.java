package kr.mmgg.auction.login.entity;

public class UserEntity {
	private Integer userSeq;
	private Long ronaUnqIdt;
	private Long discordId;
	private String discordEmail;
	private String discordGlobalName;
	
	public Integer getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}
	public Long getRonaUnqIdt() {
		return ronaUnqIdt;
	}
	public void setRonaUnqIdt(Long ronaUnqIdt) {
		this.ronaUnqIdt = ronaUnqIdt;
	}
	public Long getDiscordId() {
		return discordId;
	}
	public void setDiscordId(Long discordId) {
		this.discordId = discordId;
	}
	public String getDiscordEmail() {
		return discordEmail;
	}
	public void setDiscordEmail(String discordEmail) {
		this.discordEmail = discordEmail;
	}
	public String getDiscordGlobalName() {
		return discordGlobalName;
	}
	public void setDiscordGlobalName(String discordGlobalName) {
		this.discordGlobalName = discordGlobalName;
	}
}
