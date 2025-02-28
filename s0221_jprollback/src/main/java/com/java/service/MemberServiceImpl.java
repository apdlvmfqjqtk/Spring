package com.java.service;

import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Override  //로그인 확인
	public MemberDto findByIdAndPw(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

}