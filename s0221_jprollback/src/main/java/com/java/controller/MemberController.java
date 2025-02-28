package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	// 로그인 페이지 띄우기
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	//로그인 요청 보내기
	@PostMapping("/login")
	public String login(String id, String pw) {
		MemberDto memberDto = memberService.findByIdAndPw(id,pw);
		if(memberDto != null) {  // memberDto가 있다면(내 계정정보가 DB에 있다면)
			System.out.println("로그인이 되었습니다.");
			session.setAttribute("session_id", id);
			return "redirect:/";
		}else {
			System.out.println("로그인이 되지 않았습니다.");
		}
		return "redirect:/login?loginChk=0";
	}
	
}