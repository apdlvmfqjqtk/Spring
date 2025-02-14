package com.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

@Mapper
public interface MemberMapper {

	//로그인확인
	MemberDto selectLogin(MemberDto mdto);
	
	
	
	
}