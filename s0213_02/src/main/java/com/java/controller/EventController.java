package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.EventDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired EventService eventService;
	@Autowired HttpSession session;
	
	// event게시글 전부 가져오기
	@GetMapping("/event")
	public String event(Model model) {
		ArrayList<EventDto> list = eventService.event();
		System.out.println("돌려주기 : " + list);
		model.addAttribute("list", list);
		return "/event/event";
	}
	
}