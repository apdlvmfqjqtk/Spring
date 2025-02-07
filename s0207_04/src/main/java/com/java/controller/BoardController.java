package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/blist")
	public String board(Model model) {
		//service 연결 - 게시글의 전체를 받으려고 한다 (ArrayList) || 하나만 받으려고 한다 (Dto)
		ArrayList<BoardDto> list = boardService.list();
		model.addAttribute("list", list);
		System.out.println("개수 : "+list.size());
		System.out.println("boardcontroller 통과");
		return "board/blist";
	}
	
	@GetMapping("/bview")
	public String bview() {
		System.out.println("bno");
//		BoardDto boardDto = BoardService.bview(bno);
		
		return "board/bview";
	}
	
	
}