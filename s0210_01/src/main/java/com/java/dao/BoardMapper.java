package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {
	//게시글 보기
	ArrayList<BoardDto> selectAll();

	//글쓰기 저장
	int insertBoard(BoardDto bdto);

}