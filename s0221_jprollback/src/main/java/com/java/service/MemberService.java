package com.java.service;

import com.java.dto.MemberDto;

public interface MemberService {

	//로그인 요청 보냄	
	MemberDto findByIdAndPw(String id, String pw);

}