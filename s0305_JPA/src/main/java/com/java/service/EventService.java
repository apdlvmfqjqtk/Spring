package com.java.service;

import java.util.List;

import com.java.dto.EventDto;

public interface EventService {
	
	//이벤트목록보기
	List<EventDto> findAll();

	//글상세보기
	EventDto findByEno(int eno);

	
	//글쓰기저장
	void eventSave(EventDto edto);
	
}