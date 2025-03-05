package com.java.controller;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.ArtistDto;
import com.java.dto.ShopDto;
import com.java.service.ArtistService;
import com.java.service.ShopService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {

	@Autowired HttpSession session;
	@Autowired ShopService shopService;
	@Autowired ArtistService artistService;
	
	//메인 화면 호출
	@GetMapping("/smain")
	public String smain(Model model) {
		List<ArtistDto> list = artistService.findAll();
		model.addAttribute("list", list);
		return "smain";
	}
	
	// 아티스트물건 전체 리스트 호출
	@GetMapping("/sprods")
	public String sprods(@RequestParam("artistNo") int artist_no, Model model) {
		System.out.println("artist_no : " + artist_no);
		List<ShopDto> list = shopService.findByNo(artist_no);
		model.addAttribute("slist", list);
		System.out.println("데이터 : " + list);
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