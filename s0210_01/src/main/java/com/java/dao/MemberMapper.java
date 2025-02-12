package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto selectLogin(String id, String pw);

	//회원가입
	int insertMember(MemberDto mdto);

}