package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.BoardDto;

public interface BoardService {

	//게시글 전체리스트, 검색어 포함
	Map<String, Object> blist(int page, String category, String searchW);

	void bwrite(BoardDto bdto); //글쓰기 저장

	Map<String, Object> bview(int bno); // 1개 게시글 가져오기

	void bdelete(int bno);

	//게시글 수정페이지
	BoardDto bupdate(int bno);

	//게시글 수정 저장
	void bupdate(BoardDto bdto);

	//답변달기 페이지
	BoardDto breply(int bno);

	//답변달기 등록
	void breply(BoardDto bdto);

}
