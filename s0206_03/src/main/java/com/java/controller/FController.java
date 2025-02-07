package com.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.MemberDto;
import com.java.dto.StuDto;
import com.java.service.BService;
import com.java.service.BServiceImpl;
import com.java.service.BServiceImpl2;
import com.java.service.BServiceImpl3;
import com.java.service.BServiceImpl4;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FController {
	@Autowired
	HttpSession session;
	
	//1. 객체선언
	@Autowired BService b;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("data4")
	public String data4() {
		String str = b.slist();
		System.out.println(str);
		
		return "data4";
	}
	
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	
	@PostMapping("/meminfo")
	public String memInfo(MemberDto mDto, Model model) {
		System.out.println("id : "+mDto.getId());
		System.out.println("hobby : "+mDto.getHobby());
		
		model.addAttribute("member", mDto);
		return "memberinfo";
	}
	
	@GetMapping("/stuInput")
	public String stuInput() {
		return "stuInput";
	}
	
	@PostMapping("StuInput")
	public String StuInput(StuDto sD, Model model) {
		sD.setTotal(sD.getKor()+sD.getEng()+sD.getMath());
		sD.setAvg(sD.getTotal()/3.0);
		model.addAttribute("st", sD);
		return "doStuInput";
	}
	
	@GetMapping("/data")
	public String data(@RequestParam(defaultValue = "1") int bno, Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno", bno);
		return "data";
	}
	
	@GetMapping("/dat2/{bno}")
	public String data2(@PathVariable int bno, Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno", bno);
		return "data2";
	}
	
	@GetMapping("/dat3/{bno}") //PathVariable방식, 여러개 받음
	public String data3(@PathVariable List<Integer> bno,
			Model model) {
		System.out.println("bno : "+bno);
		model.addAttribute("bno", bno);
		return "data3";
	}
	
}