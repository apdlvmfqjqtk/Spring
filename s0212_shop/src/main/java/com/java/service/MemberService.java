package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {
	
	//로그인 확인
	MemberDto login(MemberDto mdto);

	//이메일 전송 - text
	String sendEmail(String email);

	//이메일 발송 - html
	String sendEmail2(String email);

}