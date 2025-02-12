package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//게시글 전체리스트, 검색어 포함 - 시작번호, 끝번호, 카테고리, 검색어
	ArrayList<BoardDto> selectAll(int startrow, int endrow, String category, String searchW);

	void insertBoard(BoardDto bdto);

	//1개 게시글 가져오기
	BoardDto selectOne(int bno);
	//이전게시글 가져오기
	BoardDto selectOnePrev(int bno);
	//다음게시글정보
	BoardDto selectOneNext(int bno);
	
	//조회수 1증가
	void updateBhit(int bno);

	//게시글 삭제
	void deleteBoard(int bno);

	//게시글 수정 저정
	void updateBoard(BoardDto bdto);

	//답변달기 : 자식 게시글 bstep +1
	void bstepUp(BoardDto bdto);
	//답변달기 저장
	void insertBreply(BoardDto bdto);

	//하단넘버링 - 게시글 총 개수, 검색어 총 개수
	int countAll(String category, String searchW);





}