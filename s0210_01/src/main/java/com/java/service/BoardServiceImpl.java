package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	
	@Override // 게시글 전체리스트
	public ArrayList<BoardDto> blist() {
		ArrayList<BoardDto> list = boardMapper.selectAll();
		return list;
	}

	@Override // 게시글저장
	public void boardwrite(BoardDto bdto) {
		int result = boardMapper.insertBoard(bdto);
		System.out.println("BoardServiceImpl 결과값 : " + result);
		
	}

}