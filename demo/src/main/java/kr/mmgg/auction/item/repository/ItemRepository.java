package kr.mmgg.auction.item.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.mmgg.auction.item.dto.AuctionDetailDto;
import kr.mmgg.auction.item.dto.PostDto;
import kr.mmgg.auction.item.dto.SearchItemOptionDto;
import kr.mmgg.auction.item.dto.SearchMyAddItemDto;
import kr.mmgg.auction.item.dto.SearchNameDto;
import kr.mmgg.auction.item.dto.SelectItemDto;
import kr.mmgg.auction.item.entity.ItemDetailEntity;
import kr.mmgg.auction.item.entity.ItemInfoEntity;
import kr.mmgg.auction.item.entity.Post;
import kr.mmgg.auction.login.entity.UserEntity;

@Mapper
@Repository
public interface ItemRepository {
	public List<SearchNameDto> searchName(String itemName);
	
	public List<ItemDetailEntity> searchAllItemInfo(Integer itemInfoSeq);
	
	public ItemInfoEntity searchItemInfo(Integer itemInfoSeq);
	
	public List<AuctionDetailDto> searchAuctionDtoList(Integer itemInfoSeq);
	
	public List<AuctionDetailDto> searchOptionAuctionDtoList(@Param("dto") SearchItemOptionDto searchItemOptionDto);
	
	public void insertReport(Integer auctionSeq, Integer userSeq);
	
	public void insertItemDetail(@Param("dto") SelectItemDto selectItemDto);
	
	public void insertAuction(@Param("dto") SelectItemDto selectItemDto);
	
	public List<SearchMyAddItemDto> searchMyAddItem(Integer userSeq);
	
	public void sellOk(Integer auctionSeq);
	
	public UserEntity userSearch(Integer userSeq);
	
	public List<PostDto> raidPartyPost();
	
	public void raidPartyPostAdd(@Param("dto") Post post);
}
