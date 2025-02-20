package com.java.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

import jakarta.mail.Multipart;

@Controller
public class FController {

	@Autowired BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "index";	
	}
	
	@GetMapping("/bwrite")
	public String bwrite() {
		return "bwrite";
	}
	
	@GetMapping("/blist")
	public String blist() {
		return "blist";
	}
	
	@GetMapping("/bview")
	public String bview(int bno, Model model) {
		//1개 게시글 가져오기
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("bdto", boardDto);
		return "bview";
	}
	
	
	@PostMapping("/summernoteUpload")
	@ResponseBody
	public String bwrite(BoardDto bdto,@RequestPart MultipartFile file) throws Exception {
		String realFileName = "";
		bdto.setBfile(""); // bfile null이면에러
		if(!file.isEmpty()) {
			String origin = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			realFileName = String.format("%d_%s", time, origin);
			System.out.println("파일 이름 : "+realFileName);
			String url = "c:/upload/board";
			File f = new File(url+realFileName); // 파일 객체 생성
			file.transferTo(f);
			bdto.setBfile(realFileName);
		}
		
		boardService.bwrite(bdto);
		System.out.println("content : "+bdto.getBcontent());
		System.out.println("파일첨부 완료");
		
		
		return "upload/board"+realFileName;
	}
	
}