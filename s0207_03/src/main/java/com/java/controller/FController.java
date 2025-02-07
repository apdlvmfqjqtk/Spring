package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.java.dto.BoardDto;
import com.java.service.BService;


@Controller
public class FController {
	
	@Autowired
	BService bService;
	
	@GetMapping("/")
	public String index() {
		System.out.println("Index Controller 통과");
		return "index";
	}
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = bService.blist();
		model.addAttribute("list", list);
		System.out.println("Blist Controller 통과");
		return "blist";
	}
	
}