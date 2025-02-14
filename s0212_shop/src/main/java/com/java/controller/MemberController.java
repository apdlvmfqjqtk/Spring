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

	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String login(MemberDto mdto, Model model) {
		System.out.println("impl : " + mdto);
		MemberDto memberDto = memberService.login(mdto);
		if(memberDto != null) {
			session.setAttribute("session_id", memberDto.getId()); //아이디 세션에  저장
			return "redirect:/?loginChk=1";
		}else {
			model.addAttribute("loginChk", "0");
			return "/member/login";
		}
	}
	
}