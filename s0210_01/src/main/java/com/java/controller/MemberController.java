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
	
	@GetMapping("/member") //회원가입 페이지
	public String member() {
		return "member" ;
	}
	@PostMapping("/member") //회원가입 저장
	public String member(MemberDto mdto) {
		System.out.println("입력된 name : " + mdto.getName());
		memberService.member(mdto);
		return "redirect:/" ; 
	}
	
	@GetMapping("/logout")   //로그아웃
	public String logout(Model model) {
		session.invalidate();
		model.addAttribute("chkLogin", "0");
		return "logout" ;
	}
	// 로그인 페이지 열기
	@GetMapping("/login")
	public String login() {  // 정석 @Requestparam("id") String id
		return "login";
	}
	
	// 로그인 체크하기
	@PostMapping("/login")
	public String login(String id, String pw, Model model) {  // 정석 @Requestparam("id") String id
		MemberDto memberDto = memberService.login(id,pw);
		if(memberDto != null) {
			model.addAttribute("chkLogin", "1");
			session.setAttribute("session_id", id);
			session.setAttribute("session_name", id);
		}else {
			model.addAttribute("chkLogin", "0");
		}
		return "login";
	}


}