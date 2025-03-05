package com.java.service;

import java.util.List;

import com.java.dto.MemberDto;

public interface MemberService {

	// JPA 회원전체 가져오기
	List<MemberDto> findAll();


}