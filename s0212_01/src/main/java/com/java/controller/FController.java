package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.java.dto.BoardDto;
import com.java.service.BoardService;

@Controller
public class FController {
	@Autowired BoardService boardService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/board/bview")
	public String bview(int bno,Model model) {
		BoardDto boardDto = boardService.bview(bno);
		model.addAttribute("bdto",boardDto);
		return "bview";
	}
	
	@GetMapping("/board/blist")
	public String blist(Model model) {
		ArrayList<BoardDto> list = boardService.blist();
		model.addAttribute("list", list);
		return "blist";
	}
	
	@PostMapping("/board/bwrite") // 1개 파일을 업로드
	public String bwrite(BoardDto bdto, @RequestPart MultipartFile files) throws Exception {
		String real_fname = "";
		if(!files.isEmpty()) {//파일 첨부가 되어있으면
			//최초 파일이름 -> 중복방지를 위해 파일이름변경
			String origin_fname = files.getOriginalFilename();
			System.out.println("최초 파일 이름 : " + origin_fname);
			long time = System.currentTimeMillis();
			//랜덤문자 생성객체 UUID
			// UUID uuid = UUID.randomUUID();
			// String uname = uuid+"_"+origin_fname;
			
			real_fname = String.format("%d_%s",time,origin_fname);
			System.out.println("변경파일이름 : "+real_fname);
			//파일저장위치
			String url = "C:/upload/board/"; // 파일업로드
//			String url = "C:/worksts/s0212_01/src/main/resources/static/upload/";
			
			//파일저장
			File f = new File(url+real_fname);
			
			//파일업로드
			files.transferTo(f);
			// dto에 파일이름저장
			bdto.setBfile(real_fname);
		}else {
			bdto.setBfile("");
		}
		boardService.bwrite(bdto);
		
		System.out.println("파일업로드성공");
		return "redirect:/?fname="+real_fname;
	}
	
	@PostMapping("/board/bwrite") // 2개 이상 파일을 업로드
	public String bwrite(BoardDto bdto, List<MultipartFile> files) throws Exception {
		String real_fname = "";
		if(!files.isEmpty()) {//파일 첨부가 되어있으면
			
			for(MultipartFile file : files) {
				
			
			//최초 파일이름 -> 중복방지를 위해 파일이름변경
			String origin_fname = file.getOriginalFilename();
			System.out.println("최초 파일 이름 : " + origin_fname);
			long time = System.currentTimeMillis();
			//랜덤문자 생성객체 UUID
			// UUID uuid = UUID.randomUUID();
			// String uname = uuid+"_"+origin_fname;
			
			real_fname = String.format("%d_%s",time,origin_fname);
			System.out.println("변경파일이름 : "+real_fname);
			//파일저장위치
			String url = "C:/upload/board/"; // 파일업로드
//			String url = "C:/worksts/s0212_01/src/main/resources/static/upload/";
			
			//파일저장
			File f = new File(url+real_fname);
			
			//파일업로드
			file.transferTo(f);
			}
			// dto에 파일이름저장
			bdto.setBfile(real_fname);
		}else {
			bdto.setBfile("");
		}
		boardService.bwrite(bdto);
		
		System.out.println("파일업로드성공");
		return "redirect:/?fname="+real_fname;
	}
	
	@GetMapping("/board/bwrite")
	public String bwrite() {
		return "bwrite";
	}

	
}