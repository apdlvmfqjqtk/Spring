package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.StuDto;

@Service
public class BServiceImpl2 implements BService {
	
	public String slist() {
		//실제적으론 보낼 리스트
		ArrayList<StuDto> list = new ArrayList<>();
		return "여러개 보냄2";
	}
	
	
}//class