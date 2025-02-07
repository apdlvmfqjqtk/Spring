package com.java.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.java.dto.MemberDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@Autowired
	HttpSession session;
	
	@GetMapping("/")
	public String index() {
		System.out.println("index 페이지가 열립니다.");
		MemberDto m = new MemberDto();
		
		
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("login 페이지가 열립니다.");
		System.out.println("login get방식");
		return "login";
	}
	
	//똑같은 이름이지만 매개변수를 다르게 해서(오버로딩) 쓰는 경우도 있다.
	@PostMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		System.out.println("login post방식");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		session.setAttribute("session_id", id);
		
		return "logininfo";
	}
	
	@RequestMapping("logout")  // getMapping, PostMapping 2개 모두 사용	
	public String logout() {
		session.invalidate();
		return "logout";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	
//	회원가입 눌렀을 때 post
	@PostMapping("/member")
	public ModelAndView member(HttpServletRequest request,Model model) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String gender = request.getParameter("gender");
		String[] hobbys = request.getParameterValues("hobby");
		String hobby = "";
		for(int i=0;i<hobbys.length;i++) {
			if(i==0) hobby += hobbys[i];
			else hobby += ","+hobbys[i];
		}
		System.out.printf("%s + %s + %s + %s + %s + %s",id, pw, name, tel, gender, hobby);
		
		//model 사용
//		model.addAttribute("member", new MemberDto(id, pw, name, tel, gender, hobby));
		
		//ModelAndView
		ModelAndView mv = new ModelAndView();
		mv.setViewName("meminfo");
		mv.addObject("member", new MemberDto(id, pw, name, tel, gender, hobby));
		return mv;
		
//		return "meminfo";
	}
	
	@GetMapping("/meminfo")
	public String meminfo() {
		return "meminfo";
	}
	@GetMapping("/logininfo")
	public String logininfo() {
		return "logininfo";
	}
	
}//class