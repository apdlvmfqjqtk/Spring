package com.java.service;

import java.util.ArrayList;

import com.java.dto.CboardDto;
import com.java.dto.EventDto;

public interface EventService {

	//게시글 리스트 보기
	ArrayList<EventDto> event();

	//게시글상세보기
	EventDto eview(int eno);
	//게시글 상세보기 하단댓글 가져오기
	ArrayList<CboardDto> clist(int eno);

	//하단댓글 저장
	CboardDto cwrite(CboardDto cdto);

	//댓글 수정
	CboardDto cupdate(CboardDto cdto);

	//하단댓글 삭제
	void cdelete(int cno);


}