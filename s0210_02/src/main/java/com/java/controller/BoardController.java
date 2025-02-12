package com.java.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardService boardService;
	
	@GetMapping("breply")// 게시글 답변달기
	public String breply(int bno, int page, Model model) {
		System.out.println("BoardController-breply-bno-get : " + bno);
		BoardDto boardDto = boardService.breply(bno);
		model.addAttribute("bdto", boardDto);
		return "breply";
	}
	
	@PostMapping("breply")// 게시글 답변달기 등록
	public String breply(BoardDto bdto, Model model) {
		System.out.println("BoardController-breply-bno-post : " + bdto.getBno());
		boardService.breply(bdto);
		return "redirect:/board/blist";
	}
	
	@PostMapping("bupdate")// 게시글 수정 저장
	public String bupdate(BoardDto bdto,int page, Model model) {
		System.out.println("BoardController-bupdate-bno : " + bdto.getBno());
		boardService.bupdate(bdto);
		return "redirect:/board/blist";
	}
		
	@GetMapping("bupdate")// 글쓰기 페이지
	public String bupdate(int bno, int page, Model model) {
		BoardDto boardDto = boardService.bupdate(bno);
		model.addAttribute("bdto", boardDto);
		model.addAttribute("page", page);
		System.out.println("bupdate : "+boardDto.getBcontent());
		return "bupdate";
	}
	
	@GetMapping("bdelete")// 게시글 삭제
	public String bdelete(int bno, Model model) {
		System.out.println("BoardController-bdelete-bno : " + bno);
		boardService.bdelete(bno);
		return "redirect:/board/blist";
	}
	
	@GetMapping("bview")// 글 상세보기 페이지
	//int로 타입을 정하는 경우 아무것도 없을 때,(null)값을 int가 처리 못해서 디폴트값 넣어줘야함(String은 null도 받아서 에러가안남)
	public String bview(@RequestParam(defaultValue = "1") int bno, int page ,Model model) {
		//1개 게시글 가져오기 (Dto)
		Map<String, Object> map = boardService.bview(bno);
		model.addAttribute("bdto", map.get("boardDto"));
		model.addAttribute("pdto", map.get("prevDto"));
		model.addAttribute("ndto", map.get("nextDto"));
		model.addAttribute("page", page);
		return "bview";
	}
	
	@GetMapping("bwrite")// 글쓰기 페이지
	public String bwrite() {
		return "bwrite";
	}
	
	@PostMapping("bwrite") // 글쓰기 저장
	public String bwrite(BoardDto bdto, @RequestPart MultipartFile files)throws Exception {
		bdto.setBfile("");
		
		if(!files.isEmpty()) {
			String origin = files.getOriginalFilename(); // r01.jsp
			long time = System.currentTimeMillis();
			String realFileName = String.format("%d_%s", time, origin);
			String url = "c:/upload/board";
			File f = new File(url+realFileName);
			files.transferTo(f);
			bdto.setBfile(realFileName);
		}
		
		boardService.bwrite(bdto);
		return "redirect:/board/blist";
	}
	
	//게시글 전체 리스트,검색
	@GetMapping("blist")
	public String blist(@RequestParam(value="page", defaultValue = "1")int page,String category, String searchW, Model model) {
		System.out.println("카테고리 : "+category);
		System.out.println("검색단어 : "+searchW);
		//리스트출력, 페이지, 카ㅌ고리, 검색어
		Map<String, Object> map = boardService.blist(page, category, searchW);
//		model.addAttribute("map", map); // 이렇게 한번에 넘기는거도 가능
		model.addAttribute("list", map.get("list"));
		model.addAttribute("page", map.get("page"));
		model.addAttribute("startpage", map.get("startpage"));
		model.addAttribute("endpage", map.get("endpage"));
		model.addAttribute("maxpage", map.get("maxpage"));
		model.addAttribute("category", map.get("category"));
		model.addAttribute("searchW", map.get("searchW"));
		return "blist";
	}
	
	
}