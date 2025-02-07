package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FController {

	@GetMapping("/")
	public String index(String chk) {
		System.out.println("chk 값 : "+chk); // 로그인 할 때만 값이 넘어감
		return "index";
	}
	
}
