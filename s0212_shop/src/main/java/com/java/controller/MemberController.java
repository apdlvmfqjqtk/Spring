package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired HttpSession session;
	@Autowired MemberService memberService;
	
	@GetMapping("/step02")//약관동의
	public String step02() {
		session.removeAttribute("pwCode");
		return "/member/step02";
	}
	
	@GetMapping("/step01")//회원가입
	public String step01() {
		return "/member/step01";
	}
	
	@ResponseBody // 이메일 발송
	@PostMapping("/sendEmail")
	public String sendEmail(String email) {
		System.out.println("sendEmail : " + email);
//		String pwCode = memberService.sendEmail(email); // email발송 - text
		String pwCode = memberService.sendEmail2(email); // email발송 - html
		
		return pwCode;
	}
	
	@ResponseBody // 인증코드 확인 발송
	@PostMapping("/pwCodeCheck")
	public String pwCodeCheck(String pwCode) {
		System.out.println("pwCode : " + pwCode);
		String pw = (String)session.getAttribute(pwCode);
		if(pwCode.equals(pw)) {
			return "1";
		}else {
			return "0";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/?loginChk=0";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
//	@GetMapping("/login")
//	public String login(HttpServletResponse response) {
//		//쿠키 생성
//		Cookie cookie = new Cookie("cookie_id", "aaa");
//		cookie.setMaxAge(60*60*24); //(s*m*h)
//		response.addCookie(cookie); // 쿠키 저장
//		return "/member/login";
//	}
	
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