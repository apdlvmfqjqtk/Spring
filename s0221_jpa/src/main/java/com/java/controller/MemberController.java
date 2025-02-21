package com.java.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired MemberService memberService;
	@Autowired HttpSession session;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String login(String id,String pw) {
		MemberDto memberDto = memberService.FindbyIdAndPw(id,pw);
		if(memberDto != null) {
			System.out.println("로그인 완료");
			session.setAttribute("session_id", id);
			return "redirect:/";
		}else {
			System.out.println("로그인이 되지 않았습니다");
		}
		return "/login?logiinChk=0";
	}
	
	@GetMapping("/member")
	public String member() {
		return "member";
	}
	
	@PostMapping("/member")
	public String member(MemberDto mdto) {
		memberService.save(mdto);
		return "redirect:/";
	}
	
	@GetMapping("/mlist")
	public String mlist(Model model) {
		//전체 회원리스트
		List<MemberDto> list = memberService.FimdAll();
		model.addAttribute("list", list);
		return "mlist";
	}
	
	@GetMapping("/memInfo")
	public String memInfo(Model model, String id) {
		//회원정보 1명 - selectOne
		MemberDto memberDto = memberService.FindbyId(id);
		model.addAttribute("mdto", memberDto);
		return "memInfo";
	}
	
	@GetMapping("/memUpdate")
	public String memUpdate(Model model, String id) {
		//회원정보 1명 - selectOne
		MemberDto memberDto = memberService.FindbyId(id);
		model.addAttribute("mdto", memberDto);
		return "memUpdate";
	}
	
	@PostMapping("/memUpdate")
	public String memUpdate(Model model, MemberDto mdto) {
		MemberDto memberDto = memberService.FindbyId(mdto.getId());
		memberDto.setPw(mdto.getPw());
		memberDto.setName(mdto.getName());
		memberDto.setPhone(mdto.getPhone());
		memberDto.setGender(mdto.getGender());
		memberDto.setHobby(mdto.getHobby());
		memberDto.setMdate(memberDto.getMdate()); //날짜확인
		memberService.save(mdto); // id가 존재하면 update 실행, id가 존재하지 않으면 save 실행 (findById 검색이 선제조건, 안하면 무조건 insert도 동작해서 에러)
		
		model.addAttribute("mdto", memberDto);
		return "redirect:/mlist";
	}
	
	@ResponseBody
	@PostMapping("/memDelete") //회원정보 삭제
	public String memDelete(String id) {
		//회원정보 삭제
		System.out.println("id : " + id);
		memberService.deleteById(id);
		
		return "1";
	}
}