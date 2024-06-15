package kr.mmgg.auction.item.dto;

public class PostDto {
	private Integer postId;
	private String title;
	private String charName;
	private Integer userSeq;
	private Integer charLevel;
	private Integer charDmg;
	private String category;
	private String discordId;
	private String insDate;
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCharName() {
		return charName;
	}
	public void setCharName(String charName) {
		this.charName = charName;
	}
	public Integer getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}
	public Integer getCharLevel() {
		return charLevel;
	}
	public void setCharLevel(Integer charLevel) {
		this.charLevel = charLevel;
	}
	public Integer getCharDmg() {
		return charDmg;
	}
	public void setCharDmg(Integer charDmg) {
		this.charDmg = charDmg;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDiscordId() {
		return discordId;
	}
	public void setDiscordId(String discordId) {
		this.discordId = discordId;
	}
	public String getInsDate() {
		return insDate;
	}
	public void setInsDate(String insDate) {
		this.insDate = insDate;
	}
}
