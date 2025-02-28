package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.dto.CboardDto;
import com.java.service.EventService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/event")
@RestController // 데이터만 받는 형태의 컨트롤러
public class ReController {
	
	@Autowired EventService eventService;
	@Autowired HttpSession session;	
	//댓글 달기
	@PostMapping("/cwrite")
	public CboardDto cwrite(CboardDto cdto) {
		System.out.println("eno : " +cdto.getEno());
		System.out.println("cpw : " +cdto.getCpw());
		System.out.println("ccontent : " +cdto.getCcontent());
		cdto.setId("session_id"); // => 나중에 session_id로 바꾸면 됨, 바로 밑줄처럼
//		String id = session.getAttribute("session_id");
		//댓글저장
		CboardDto cboardDto = eventService.cwrite(cdto);
		return cboardDto; // 데이터를 전달함, 페이지를 전달하는것이 아님
	}
	
	@PostMapping("/cupdate")
	public CboardDto cupdate(CboardDto cdto) {
		System.out.println("eno : " +cdto.getEno());
		System.out.println("cno : " +cdto.getCno());
		System.out.println("ccontent : " +cdto.getCcontent());
		cdto.setId("aaa"); // => 나중에 session_id로 바꾸면 됨, 바로 밑줄처럼
//		String id = session.getAttribute("session_id");
		//댓글저장
		CboardDto cboardDto = eventService.cupdate(cdto);
		return cboardDto; // 데이터를 전달함, 페이지를 전달하는것이 아님
	}
	
	@PostMapping("/cdelete")
	public String cdelete(int cno) {
		
		//하단댓글 삭제
		eventService.cdelete(cno);
		return "1"; // 데이터를 전달함, 페이지를 전달하는것이 아님
	}
	
	
}