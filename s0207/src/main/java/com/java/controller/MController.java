package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MController {
	
	@Autowired HttpSession session; //세션 객체
	
//	@RequestMapping(method=RequestMethod.GET, vlaue="/member/login") //예전버전
	@GetMapping("/login") // 간략화시킨 요즘버전
	public String login(String chk) {
		System.out.println("chk : "+chk);
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(String id, String pw, Model model) {
		//DB 접근해서 id, pw가 맞는지 확인
		if(id.equals("aaa") && pw.equals("1111")) {
			return "redirect:/?chk=1";
		}else {
			return "redirect:/member/login?chk=0";	
		}
	}//login
		
	@GetMapping("/logout")
	public String logout() {
		session.invalidate(); //세션모두삭제
		return "redirect:/?outChk=1";
	}
	
}//class