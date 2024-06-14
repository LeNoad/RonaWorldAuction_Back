package kr.mmgg.auction.item.dto;

public class SelectItemDto {
	private Integer itemDetailSeq;
	private Integer itemInfoSeq;
	private String itemName;
	
	private Integer userSeq;
	
	private Integer atkPt;
	private Integer mgcPt;
	
	private Integer strPt;
	private Integer dexPt;
	private Integer intPt;
	private Integer lukPt;
	
	private Integer phyDef;
	private Integer mgcDef;
	
	private Integer accRate;
	private Integer evaRate;
	
	private Integer jmpPt;
	private Integer movSpd;
	
	private Integer upgradeCount;
	private Long auctionPrice;
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemDetailSeq() {
		return itemDetailSeq;
	}
	public void setItemDetailSeq(Integer itemDetailSeq) {
		this.itemDetailSeq = itemDetailSeq;
	}
	public Integer getItemInfoSeq() {
		return itemInfoSeq;
	}
	public void setItemInfoSeq(Integer itemInfoSeq) {
		this.itemInfoSeq = itemInfoSeq;
	}
	public Integer getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}
	public Integer getAtkPt() {
		return atkPt;
	}
	public void setAtkPt(Integer atkPt) {
		this.atkPt = atkPt;
	}
	public Integer getMgcPt() {
		return mgcPt;
	}
	public void setMgcPt(Integer mgcPt) {
		this.mgcPt = mgcPt;
	}
	public Integer getStrPt() {
		return strPt;
	}
	public void setStrPt(Integer strPt) {
		this.strPt = strPt;
	}
	public Integer getDexPt() {
		return dexPt;
	}
	public void setDexPt(Integer dexPt) {
		this.dexPt = dexPt;
	}
	public Integer getIntPt() {
		return intPt;
	}
	public void setIntPt(Integer intPt) {
		this.intPt = intPt;
	}
	public Integer getLukPt() {
		return lukPt;
	}
	public void setLukPt(Integer lukPt) {
		this.lukPt = lukPt;
	}
	public Integer getPhyDef() {
		return phyDef;
	}
	public void setPhyDef(Integer phyDef) {
		this.phyDef = phyDef;
	}
	public Integer getMgcDef() {
		return mgcDef;
	}
	public void setMgcDef(Integer mgcDef) {
		this.mgcDef = mgcDef;
	}
	public Integer getAccRate() {
		return accRate;
	}
	public void setAccRate(Integer accRate) {
		this.accRate = accRate;
	}
	public Integer getEvaRate() {
		return evaRate;
	}
	public void setEvaRate(Integer evaRate) {
		this.evaRate = evaRate;
	}
	public Integer getJmpPt() {
		return jmpPt;
	}
	public void setJmpPt(Integer jmpPt) {
		this.jmpPt = jmpPt;
	}
	public Integer getMovSpd() {
		return movSpd;
	}
	public void setMovSpd(Integer movSpd) {
		this.movSpd = movSpd;
	}
	public Integer getUpgradeCount() {
		return upgradeCount;
	}
	public void setUpgradeCount(Integer upgradeCount) {
		this.upgradeCount = upgradeCount;
	}
	public Long getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(Long auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
}
