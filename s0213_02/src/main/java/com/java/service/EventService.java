package com.java.service;

import java.util.ArrayList;

import com.java.dto.EventDto;

public interface EventService {

	// event게시글 전부 가져오기
	ArrayList<EventDto> event();

}
