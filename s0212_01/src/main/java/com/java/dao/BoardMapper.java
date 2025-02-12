package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//글 전체보기
	ArrayList<BoardDto> selectAll();

	//게시글저장
	void insertBoard(BoardDto bdto);

	static BoardDto selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

}