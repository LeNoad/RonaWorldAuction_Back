package kr.mmgg.auction.item.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.mmgg.auction.cmm.ResultDto;
import kr.mmgg.auction.item.dto.ReportRequestDto;
import kr.mmgg.auction.item.dto.SearchItemOptionDto;
import kr.mmgg.auction.item.dto.SelectItemDto;
import kr.mmgg.auction.item.dto.SellOkDto;
import kr.mmgg.auction.item.dto.discordId;
import kr.mmgg.auction.item.repository.ItemRepository;
import kr.mmgg.auction.item.service.ItemService;
import kr.mmgg.auction.login.entity.UserEntity;


@RequestMapping("/rona/api")
@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemRepository itemRepository;
	/* 
	 * 2024-04-02
	 * -검색창에서 검색어-
	 * 리액트에서 한단어가 완성되면 불러오도록 설정할 예정
	 * */
	@RequestMapping("/searchName")
	public ResultDto<?> searchName(@RequestParam(value = "itemName") String itemName){
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트", itemService.searchName(itemName), "info");
	}
	
	/* 
	 * 2024-04-02
	 * -아이템 시퀀스로 경매장에 올라온 물건들 검색-
	 * OutputItemInfo DTO를 작성해서
	 * LIST 형태인 ITEM_DETAIL 데이터 [ 거래소에서 보여지게될 능력치가 추가된 모습 ]
	 * ENTITY 형태인 ITEM_INFO 데이터 [ 능력치가 추가될 아이템의 정보 ]
	 * */
	@RequestMapping("/searchAllItemInfo")
	public ResultDto<?> searchAllItemInfo(@RequestParam(value = "itemInfoSeq")Integer itemInfoSeq) {
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트", itemService.searchAllItemInfo(itemInfoSeq), "info");
	}
	
	@RequestMapping("/searchOptionItemInfo")
	public ResultDto<?> searchOptionItemInfo(@RequestBody SearchItemOptionDto searchItemOptionDto) {
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트", itemService.searchOptionsItemInfo(searchItemOptionDto), "info");
	}
	/*
	 * 2024-04-02
	 * -옥션에 아이템 등록-
	 * 
	 * */
	@RequestMapping("/addSellAuctionItem")
	public ResultDto<?> addAuctionItem(@RequestBody SelectItemDto selectItemDto) {
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트 API", itemService.addSellAuctionItem(selectItemDto), "info");
	}

	@RequestMapping("/userSearch") 
	public ResultDto<?> userSearch(@RequestParam(value = "userSeq") Integer userSeq) {
		UserEntity user = itemRepository.userSearch(userSeq);
		discordId test = new discordId();
		test.setDiscordId(Long.toString(user.getDiscordId()));
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트", test, "info");
	}
	
	@RequestMapping("/searchMyAddItem")
	public ResultDto<?> searchMyAddItem(@RequestParam(value = "userSeq") Integer userSeq) {
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트", itemService.searchMyAddItem(userSeq), "info");
	}
	@RequestMapping("/sellOk")
	public ResultDto<?> sellOk(@RequestBody SellOkDto sellOkDto) {
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트", itemService.sellOk(sellOkDto), "info");
	}
	@RequestMapping("/report")
	public ResultDto<?> report(@RequestBody ReportRequestDto reportRequestDto) {
		itemRepository.insertReport(reportRequestDto.getAuctionSeq(), reportRequestDto.getUserSeq());
		return new ResultDto<>().makeResult(HttpStatus.OK, "테스트 API", null, "info");
	}
}
