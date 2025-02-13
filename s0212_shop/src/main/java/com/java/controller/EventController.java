package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/event")
public class EventController {
	
	@Autowired EventService eventService;
	@Autowired HttpSession session;

	
	//글 상세보기
	@GetMapping("eview")
	public String eview(int eno, Model model) {
		//상세보기
		EventDto eventDto = eventService.eview(eno);
		//하단댓글
		ArrayList<CboardDto> clist = eventService.clist(eno);
		model.addAttribute("edto", eventDto);
		model.addAttribute("clist", clist);
		return "/event/eview";
	}
	
	//글 전체리스트 가져오기
	@GetMapping("event")
	public String event(Model model) {
		ArrayList<EventDto> list = eventService.event();
		model.addAttribute("list", list);
		
		return "/event/event";
	}
	
	
}