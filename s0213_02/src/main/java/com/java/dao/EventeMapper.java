package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.EventDto;

@Mapper
public interface EventeMapper {

	//이벤트 전체 글 가져오기
	ArrayList<EventDto> eventAll();
	
}