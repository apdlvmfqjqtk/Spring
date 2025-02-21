package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	void save(MemberDto mdto);
	
	List<MemberDto> FimdAll();

	MemberDto FindbyId(String id);

	//회원정보삭제
	void deleteById(String id);

	//로그인
	MemberDto FindbyIdAndPw(String id, String pw);

}