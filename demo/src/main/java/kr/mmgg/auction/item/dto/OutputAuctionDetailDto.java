package kr.mmgg.auction.item.dto;

import java.util.List;

import kr.mmgg.auction.item.entity.ItemInfoEntity;

public class OutputAuctionDetailDto {
	private ItemInfoEntity itemInfoEntity;
	private List<AuctionDetailDto> auctionDetailDtoList;
	
	public ItemInfoEntity getItemInfoEntity() {
		return itemInfoEntity;
	}
	public void setItemInfoEntity(ItemInfoEntity itemInfoEntity) {
		this.itemInfoEntity = itemInfoEntity;
	}
	public List<AuctionDetailDto> getAuctionDetailDtoList() {
		return auctionDetailDtoList;
	}
	public void setAuctionDetailDtoList(List<AuctionDetailDto> auctionDetailDtoList) {
		this.auctionDetailDtoList = auctionDetailDtoList;
	}
}
