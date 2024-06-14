package kr.mmgg.auction.item.dto;

import java.util.List;

import kr.mmgg.auction.item.entity.ItemDetailEntity;
import kr.mmgg.auction.item.entity.ItemInfoEntity;

public class OutputItemInfo {
	private List<ItemDetailEntity> itemDetailEntityList;
	private ItemInfoEntity itemInfoEntity;
	
	public List<ItemDetailEntity> getItemDetailEntityList() {
		return itemDetailEntityList;
	}
	public void setItemDetailEntityList(List<ItemDetailEntity> itemDetailEntityList) {
		this.itemDetailEntityList = itemDetailEntityList;
	}
	public ItemInfoEntity getItemInfoEntity() {
		return itemInfoEntity;
	}
	public void setItemInfoEntity(ItemInfoEntity itemInfoEntity) {
		this.itemInfoEntity = itemInfoEntity;
	}
	
}
