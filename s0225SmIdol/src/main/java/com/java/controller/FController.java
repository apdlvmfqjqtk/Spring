package com.java.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.ShopDto;
import com.java.service.ShopService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {

	@Autowired ShopService shopService;
	@Autowired HttpSession session;
	
	@GetMapping("/smain")
	public String smain() {
		return "smain";
	}
	
	@GetMapping("/sprods")
	public String sprods() {
		return "sprods";
	}
	
	@GetMapping("/sprodview")
	public String sprodview() {
		return "sprodview";
	}
	
	@GetMapping("/sptwind")
	public String sptwind() {
		return "sptwind";
	}
	
	@GetMapping("/sptdone")
	public String sptdone() {
		return "sptdone";
	}
	
	//test서버 open
	@CrossOrigin 
	@GetMapping("/test")
	public String test(Model model) {
		List<ShopDto> list = shopService.findAll();
		model.addAttribute("list", list);
		return "test";
	}
	
	
}