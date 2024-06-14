package kr.mmgg.auction.item.dto;

public class ReportRequestDto {
	private Integer auctionSeq;
	private Integer userSeq;
	
	public Integer getAuctionSeq() {
		return auctionSeq;
	}
	public void setAuctionSeq(Integer auctionSeq) {
		this.auctionSeq = auctionSeq;
	}
	public Integer getUserSeq() {
		return userSeq;
	}
	public void setUserSeq(Integer userSeq) {
		this.userSeq = userSeq;
	}
}
