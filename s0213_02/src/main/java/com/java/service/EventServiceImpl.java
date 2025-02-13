package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventeMapper;
import com.java.dto.EventDto;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired EventeMapper eventMapper;
	
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.eventAll();
		System.out.println(list);
		return list;
	}

}