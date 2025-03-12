package com.java.controller;

import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.java.dto.ApproveResponseDto;
import com.java.dto.OrderDto;
import com.java.dto.ReadyResponseDto;
import com.java.service.KakaopayService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FController {
	
	@Autowired HttpSession session;
	@Autowired KakaopayService kakaopayService;
	
	//메인페이지
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	//https://myste-leee.tistory.com/272
	//카카오페이페이지
	@GetMapping("/bview")
	public String bview() {
		return "bview";
	}
	
	//카카오페이성공
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	//카카오페이페이지 결제
	@ResponseBody
	@PostMapping("/pay/orderPay")
	public ReadyResponseDto orderPay(OrderDto odto) {
		log.info("odto name : "+odto.getName());
		System.out.println("odto name : "+odto.getName());
		
        // 카카오 결제 준비하기
        ReadyResponseDto readyResponseDto = kakaopayService.payReady(odto);
        
        // 세션에 결제 고유번호(tid) 저장
        SessionUtils.addAttribute("tid", readyResponseDto.getTid());
        log.info("결제 고유번호: " + readyResponseDto.getTid());
        return readyResponseDto;
		
	}
	
	@GetMapping("/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
    
		//섹션에서 tid값을 가져옴.
        String tid = SessionUtils.getStringAttributeValue("tid");
        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
        log.info("결제 고유번호: " + tid);

        // 카카오 결제 요청하기
        ApproveResponseDto approveResponseDto = kakaopayService.payApprove(tid, pgToken);

        System.out.println("승인날짜 : "+approveResponseDto.getApproved_at());
        
        return "redirect:/success";
    }
	

}
