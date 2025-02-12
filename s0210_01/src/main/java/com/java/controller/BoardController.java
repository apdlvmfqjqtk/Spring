package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService boardService;

	@GetMapping("/boardwrite")
	public String boardwrite() {
		return "boardwrite";
	}
	@PostMapping("/boardwrite")
	public String boardwrite(BoardDto bdto) {
		System.out.println("넘어온 btitle : "+ bdto.getBtitle());
		boardService.boardwrite(bdto); //글쓰기저장
		return "boardwrite";
	}
	
	@GetMapping("/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		System.out.println(list);
		return "blist";
	}
	
}