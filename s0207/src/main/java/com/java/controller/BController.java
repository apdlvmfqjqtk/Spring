package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;

@Controller
@RequestMapping("/board")
public class BController {
	
//	BService bService = new BService(); // 얘를 밑처럼 축약
	@Autowired BService bService;
	
	@GetMapping("/blist")
	public String board(Model model) {
		// 데시판 리스트 - 여러개의 게시글을 들고와야함 ->  Arraylist
		// 게시글 1개만 가져오기 - BoardDto
		ArrayList<BoardDto> list = bService.blist();
		
		//jsp 페이지로 보냄
		model.addAttribute("list", list);
		return "/board/blist";
	}
	
	
	
}//class