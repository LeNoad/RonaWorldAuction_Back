package kr.mmgg.auction.item.dto;

public class SearchItemOptionDto {
	private Integer itemInfoSeq;
	
	private Integer minPrice; // 최소가격
	private Integer maxPrice; // 최대가격
	private Integer upgradeLimit; // 업그레이드 된 횟수
	private Integer atkPt;
	private Integer mgcPt;
	
	
	public Integer getItemInfoSeq() {
		return itemInfoSeq;
	}
	public void setItemInfoSeq(Integer itemInfoSeq) {
		this.itemInfoSeq = itemInfoSeq;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getUpgradeLimit() {
		return upgradeLimit;
	}
	public void setUpgradeLimit(Integer upgradeLimit) {
		this.upgradeLimit = upgradeLimit;
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
}
