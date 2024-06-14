package kr.mmgg.auction.item.dto;

import kr.mmgg.auction.item.entity.ItemDetailEntity;

public class AuctionDetailDto {
	private Integer AuctionSeq;
	private Integer ItemInfoSeq;
	private Integer ItemDetailSeq;
	private Integer UserSeq;
	private Long AuctionPrice;
	private Integer TrdType;
	private Integer TrdStatus;
	
	/* 날짜 */
	private String InsDate;
	private String uptDate;
	
	private ItemDetailEntity itemDetailEntity;

	public Integer getAuctionSeq() {
		return AuctionSeq;
	}

	public void setAuctionSeq(Integer auctionSeq) {
		AuctionSeq = auctionSeq;
	}

	public Integer getItemInfoSeq() {
		return ItemInfoSeq;
	}

	public void setItemInfoSeq(Integer itemInfoSeq) {
		ItemInfoSeq = itemInfoSeq;
	}

	public Integer getItemDetailSeq() {
		return ItemDetailSeq;
	}

	public void setItemDetailSeq(Integer itemDetailSeq) {
		ItemDetailSeq = itemDetailSeq;
	}

	public Integer getUserSeq() {
		return UserSeq;
	}

	public void setUserSeq(Integer userSeq) {
		UserSeq = userSeq;
	}

	public Long getAuctionPrice() {
		return AuctionPrice;
	}

	public void setAuctionPrice(Long auctionPrice) {
		AuctionPrice = auctionPrice;
	}

	public Integer getTrdType() {
		return TrdType;
	}

	public void setTrdType(Integer trdType) {
		TrdType = trdType;
	}

	public Integer getTrdStatus() {
		return TrdStatus;
	}

	public void setTrdStatus(Integer trdStatus) {
		TrdStatus = trdStatus;
	}

	public String getInsDate() {
		return InsDate;
	}

	public void setInsDate(String insDate) {
		InsDate = insDate;
	}

	public String getUptDate() {
		return uptDate;
	}

	public void setUptDate(String uptDate) {
		this.uptDate = uptDate;
	}

	public ItemDetailEntity getItemDetailEntity() {
		return itemDetailEntity;
	}

	public void setItemDetailEntity(ItemDetailEntity itemDetailEntity) {
		this.itemDetailEntity = itemDetailEntity;
	}
}
