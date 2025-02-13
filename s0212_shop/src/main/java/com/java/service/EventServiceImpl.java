package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.EventMapper;
import com.java.dto.CboardDto;
import com.java.dto.EventDto;

@Service
public class EventServiceImpl implements EventService {

	@Autowired EventMapper eventMapper;
	
	//게시글 리스트 보기
	@Override
	public ArrayList<EventDto> event() {
		ArrayList<EventDto> list = eventMapper.selectAll();
		return list;
	}

	//게시글 하나 상세 보기
	@Override
	public EventDto eview(int eno) {
		EventDto eventDto = eventMapper.selectOne(eno);
		return eventDto;
	}
	//상세보기 하단댓글 가져오기
	@Override
	public ArrayList clist(int eno) {
		ArrayList<CboardDto> list = eventMapper.selectAllCboard(eno);
		return list;
	}

	//하단댓글 저장
	@Override  // cdto에는 cdate와 cno가 없기에 저장을 한번 하고 sql로 보내는 것
	public CboardDto cwrite(CboardDto cdto) {
		eventMapper.insertCboard(cdto); 
		System.out.println("cno : "+cdto.getCno());
		CboardDto cboardDto = eventMapper.selectOneCboard(cdto.getCno());
		System.out.println("cboardDto cno : "+cboardDto.getCno());
		
		
		return cboardDto;
	}

}