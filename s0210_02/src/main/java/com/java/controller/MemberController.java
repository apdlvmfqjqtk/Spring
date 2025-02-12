package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/login") // 로그인 페이지
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout") // 로그아웃
	public String logout() {
		session.invalidate();
		return "redirect:/?logout=1";
	}
	
	@PostMapping("/login") // 로그인 확인
	public String login(MemberDto mdto, Model model) {
		System.out.println("MemberController login : " + mdto.getId());
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto != null) {
			model.addAttribute("chkLogin", "1");
			session.setAttribute("session_id", memberDto.getId());
			session.setAttribute("session_name", memberDto.getName());
		}else {
			model.addAttribute("chkLogin", "0");
		}
		
		return "login";
	}
	
}