package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.EventDto;
import com.java.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	
	@Autowired EventRepository eventRepository;
	
	@Override
	public List<EventDto> findAll() {
		List<EventDto> list = eventRepository.findAll();
		return list;
	}

	//이벤트글상세보기
	@Override
	public EventDto findByEno(int eno) {
		EventDto eventDto = eventRepository.findByEno(eno);
		return eventDto;
	}

	
	//글쓰기저장
	@Override
	public void eventSave(EventDto edto) {
		eventRepository.save(edto);
	}

}