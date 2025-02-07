package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("mlist")
	public String mlist(Model model) {
		ArrayList<MemberDto> list = memberService.list();
		model.addAttribute("mlist", list);
		System.out.println("list(mlist)  개수 : " + list.size());
		System.out.println("콘트롤통과");
		return "/member/mlist";
	}
	
}