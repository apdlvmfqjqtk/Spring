package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {


	//파일전송
	void bwrite(BoardDto bdto);

	BoardDto bview(int bno);

	static ArrayList<BoardDto> select(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

}