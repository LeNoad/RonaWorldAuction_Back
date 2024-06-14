package kr.mmgg.auction.item.dto;

public class SearchMyAddItemDto {
	private Integer auctionSeq;
	private String itemName;
	private Long auctionPrice;
	private Integer trdStatus;
	
	
	public Integer getAuctionSeq() {
		return auctionSeq;
	}
	public void setAuctionSeq(Integer auctionSeq) {
		this.auctionSeq = auctionSeq;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Long getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(Long auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public Integer getTrdStatus() {
		return trdStatus;
	}
	public void setTrdStatus(Integer trdStatus) {
		this.trdStatus = trdStatus;
	}
	
	
}
