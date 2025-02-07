package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemDto;
import com.java.dto.StuDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FContoller {
	@Autowired
	HttpSession session;
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@GetMapping("/board")
	public String board(int bno, String btitle, Model model) {
		System.out.println("bno : "+bno);
		System.out.println("btitle : "+btitle);
		
		model.addAttribute("bno", bno);
		model.addAttribute("btitle", btitle);
		return "board";
	}
	
	@PostMapping("/stuInput")
	public String stuInput(int stuno, String name,
			int kor, int eng, int math, Model model) {
		int total = kor+eng+math;
		double avg = total/3.0;
		StuDto s = StuDto.builder().stuno(stuno).name(name).kor(kor).eng(eng).math(math).total(total).avg(avg).build();
		
		model.addAttribute("stu", s);
		
		
		return "doStuInput";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,
			@RequestParam("id") String id,  // form name = "id"입력받음
			@RequestParam(required = false) String pw, //null값 허용
			String name, ///@RequestParam 생략 가능, 대신 form이름과 같아야 함
			@RequestParam int kor,
			@RequestParam(defaultValue = "0")int eng, // 값이 없다면 0으로 세팅
			int math, 
			Model model) {
		
		int total = kor+eng+math;
		double avg = total/3.0;
		
//		String aid = request.getParameter("id");
//		String apw = request.getParameter("pw");
//		String akor = request.getParameter("kor");
//		String aeng = request.getParameter("eng");
//		String amath = request.getParameter("math");
//		
//		int k = Integer.parseInt(akor);
//		int e = Integer.parseInt(aeng);
//		int m = Integer.parseInt(amath);
//		
//		int tt = k+e+m;
//		double av = tt/3.0;
		
		System.out.println("데이터 "+id +","+ pw +","+ kor +","+eng);
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("k",kor);
		model.addAttribute("e",eng);
		model.addAttribute("tt",total);
		model.addAttribute("m",avg);
		model.addAttribute("av",avg);
//		model.addAttribute("member", MemDto.builder().id(id).name("홍길동"));
		
		return "logininfo";
		
	}
	
	
}
