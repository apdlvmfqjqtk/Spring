package com.java.service;

import java.util.ArrayList;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

public interface BoardService {

	//게시글전체리스트
	ArrayList<BoardDto> blist();

	//게시글저장
	void bwrite(BoardDto bdto);

	//게시글한개가져오기
	BoardDto bview(int bno);

}