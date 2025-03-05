package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EventController {
	
	@Autowired HttpSession session;
	@Autowired EventService eventService;
	
	
	@GetMapping("/event/event")
	public String event(Model model) {
		//전체리스트 가져오기
		List<EventDto> list = eventService.findAll();
		model.addAttribute("list",list);
		return "event/event";
	}
	
	//페이지열기
	@GetMapping("/event/eventWrite")
	public String eventWrite(Model model) {
		return "event/eventWrite";
	}
	
	// 이벤트 등록
	@PostMapping("/event/eventWrite")
	public String eventWrite(EventDto edto,
			// @RequestPart MultipartFile files,  // 파일 1개를 받을때
			@RequestPart List<MultipartFile> files, // 파일 여러개를 받음(List타입으로 받음)
			Model model) throws IllegalStateException, IOException {
		//파일저장위치
		String url = "c:/upload/event/";
		for(int i=0;i<files.size();i++) {
			String originName = files.get(i).getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s",time,originName);
			File f = new File(url+uploadFileName);
			files.get(i).transferTo(f); // 파일업로드
			if(i==0) edto.setEfile(uploadFileName);
			else edto.setEfile2(uploadFileName);
		}
		
		System.out.println("edto etitle : " + edto.getEtitle());
		System.out.println("edto Efile : " + edto.getEfile());
		System.out.println("edto Efile2 : " + edto.getEfile2());
		
		//jpa insert
		eventService.eventSave(edto);
		
		return "event/eventWrite";
//		return "redirect:/event/event";
	}
	
	@GetMapping("event/eview")
	public String eview(int eno, Model model) {	
		System.out.println(eno);
		EventDto eventDto = eventService.findByEno(eno);
		model.addAttribute("edto", eventDto);
		model.addAttribute("clist", eventDto.getClist());
		return "event/eview";
	}

}