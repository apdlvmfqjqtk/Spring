package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {
	
	//게시글 리스트
	ArrayList<BoardDto> blist();

	
	void boardwrite(BoardDto bdto);

}