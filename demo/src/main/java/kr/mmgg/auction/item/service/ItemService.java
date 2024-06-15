package kr.mmgg.auction.item.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import kr.mmgg.auction.item.dto.AuctionDetailDto;
import kr.mmgg.auction.item.dto.OutputAuctionDetailDto;
import kr.mmgg.auction.item.dto.OutputItemInfo;
import kr.mmgg.auction.item.dto.PostDto;
import kr.mmgg.auction.item.dto.SearchItemOptionDto;
import kr.mmgg.auction.item.dto.SearchMyAddItemDto;
import kr.mmgg.auction.item.dto.SearchNameDto;
import kr.mmgg.auction.item.dto.SelectItemDto;
import kr.mmgg.auction.item.dto.SellOkDto;
import kr.mmgg.auction.item.entity.Post;
import kr.mmgg.auction.item.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public List<SearchNameDto> searchName(String itemName) {
		return itemRepository.searchName(itemName);
	}

	public OutputAuctionDetailDto searchAllItemInfo(Integer itemInfoSeq) {
		OutputAuctionDetailDto outputAuctionDetilaDto = new OutputAuctionDetailDto();
		outputAuctionDetilaDto.setItemInfoEntity(itemRepository.searchItemInfo(itemInfoSeq));
		outputAuctionDetilaDto.setAuctionDetailDtoList(itemRepository.searchAuctionDtoList(itemInfoSeq));

		/*
		 * OutputItemInfo output = new OutputItemInfo();
		 * output.setItemDetailEntityList(itemRepository.searchAllItemInfo(itemInfoSeq))
		 * ; output.setItemInfoEntity(itemRepository.searchItemInfo(itemInfoSeq));
		 */
		return outputAuctionDetilaDto;
	}
	
	public OutputAuctionDetailDto searchOptionsItemInfo(SearchItemOptionDto searchItemOptionDto) {
		OutputAuctionDetailDto outputAuctionDetilaDto = new OutputAuctionDetailDto();
		outputAuctionDetilaDto.setItemInfoEntity(itemRepository.searchItemInfo(searchItemOptionDto.getItemInfoSeq()));
		outputAuctionDetilaDto.setAuctionDetailDtoList(itemRepository.searchOptionAuctionDtoList(searchItemOptionDto));
		return outputAuctionDetilaDto;
	}
	
	public OutputAuctionDetailDto addSellAuctionItem(SelectItemDto selectItemDto) {
		itemRepository.insertItemDetail(selectItemDto);
		itemRepository.insertAuction(selectItemDto);
		OutputAuctionDetailDto outputAuctionDetilaDto = new OutputAuctionDetailDto();
		outputAuctionDetilaDto.setItemInfoEntity(itemRepository.searchItemInfo(selectItemDto.getItemInfoSeq()));
		outputAuctionDetilaDto.setAuctionDetailDtoList(itemRepository.searchAuctionDtoList(selectItemDto.getItemInfoSeq()));
		return outputAuctionDetilaDto;
	}
	public List<SearchMyAddItemDto> searchMyAddItem(Integer userSeq) {
		List<SearchMyAddItemDto> list = itemRepository.searchMyAddItem(userSeq);
		return list;
	}
	
	public List<SearchMyAddItemDto> sellOk(SellOkDto sellOkDto) {
		itemRepository.sellOk(sellOkDto.getAuctionSeq());
		return itemRepository.searchMyAddItem(sellOkDto.getUserSeq());
	}
	
	public List<PostDto> raidPartyPost() {
		return itemRepository.raidPartyPost();
	}
}
