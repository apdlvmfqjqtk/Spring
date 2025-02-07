package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public ArrayList<MemberDto> list() {
		
		ArrayList<MemberDto> list = memberMapper.selectAll(); 
		
		System.out.println("서비스 통과");
		return list;
	}

}