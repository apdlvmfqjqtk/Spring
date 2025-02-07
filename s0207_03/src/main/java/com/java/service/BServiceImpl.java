package com.java.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.java.dto.BoardDto;

@Service
public class BServiceImpl implements BService {

	@Override
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = new ArrayList<>();
		System.out.println("BServiceImpl 통과");
		return list;
	}

}