package kr.mmgg.auction.item.dto;

public class SearchNameDto {
	private Integer ItemInfoSeq;
	private String ItemName;
	private Integer ImageNo;
	
	
	public Integer getImageNo() {
		return ImageNo;
	}
	public void setImageNo(Integer imageNo) {
		ImageNo = imageNo;
	}
	public Integer getItemInfoSeq() {
		return ItemInfoSeq;
	}
	public void setItemInfoSeq(Integer itemInfoSeq) {
		ItemInfoSeq = itemInfoSeq;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
}
