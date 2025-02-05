package com.java.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	
	// 얘 한번 선언하면 객체선언 따로 안해도됨
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login(HttpServletRequest request) {
		System.out.println("get 방식으로 들어왔습니다");
		return "login";
	}
	
	@PostMapping("doLogin")
	public String doLogin() {
		System.out.println("post 방식으로 들어왔습니다");
//		HttpSession session = request.getSession();
		session.setAttribute("session_id", "aaa"); // 섹션적용
		return "index";
	}
	
	
	@GetMapping("logout")
	public String logout() {
		session.invalidate(); // 섹션삭제
		return "logout";	
	}
	
}