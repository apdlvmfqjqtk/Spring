package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.BoardMapper;
import com.java.dto.BoardDto;

@Transactional
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired BoardMapper boardMapper;
	int rowPerPage = 10; // 한 페이지 당 보여줄 게시글 수
	
	@Override // 게시판 글 리스트
	public Map<String, Object> blist(int page, String category, String searchW) {
		
		int count = boardMapper.countAll(category, searchW);
		
		//마지막 페이지 넘버링
		int maxpage = (int) Math.ceil((double)count/rowPerPage);
		//첫번째 번호 넘버링
		int startpage = (int)((page-1)/10)*10+1;  // 1-10까지는 무조건 1이 나오는 구조
		//마지막 번호 넘버링
		int endpage = startpage+10-1;
		if(endpage > maxpage) endpage=maxpage;
		
		//요청페이지별 검색번호
		int startrow = (page-1)*rowPerPage+1;		//4페이지 (4-1)*10+1 = 31
		int endrow = startrow+rowPerPage-1;//		31+10-1=40
		
		//전체리스트 - 시작번호, 끝번호, 카테고리, 검색어
		ArrayList<BoardDto> list = boardMapper.selectAll(startrow,endrow,category,searchW);
		
		Map<String, Object> map = new HashMap<>(); 
		map.put("page", page);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		map.put("maxpage", maxpage);
		map.put("list", list);
		map.put("category", category);
		map.put("searchW", searchW);
		
		return map;
	}

	@Override // 글쓰기 저장
	public void bwrite(BoardDto bdto) {
		boardMapper.insertBoard(bdto);
	}

	@Override // 1개 게시글 가져오기
	public Map<String, Object> bview(int bno) {
		Map<String, Object> map = new HashMap<>();
		//조회수 1 증가
		boardMapper.updateBhit(bno);
		//현재 게시글 정보
		BoardDto boardDto = boardMapper.selectOne(bno);
		//이전 게시글 정보
		BoardDto prevDto = boardMapper.selectOnePrev(bno);
		//이전 게시글 정보
		BoardDto nextDto = boardMapper.selectOneNext(bno);
		map.put("boardDto", boardDto);
		map.put("prevDto", prevDto);
		map.put("nextDto", nextDto);
		
//		System.out.println("이전게시글 : "+prevDto.getBno());
//		System.out.println("다음게시글 : "+nextDto.getBno());
		return map;
	}

	@Override //글삭제
	public void bdelete(int bno) {
		boardMapper.deleteBoard(bno);
	}

	@Override // 게시글 수정
	public BoardDto bupdate(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override // 게시글 수정 저장
	public void bupdate(BoardDto bdto) {
		boardMapper.updateBoard(bdto);
	}

	@Override //답변달기페이지
	public BoardDto breply(int bno) {
		BoardDto boardDto = boardMapper.selectOne(bno);
		return boardDto;
	}

	@Override // 답변달기 등록
	public void breply(BoardDto bdto) {
		//같은 그룹에서 부모보다 bstep이 높은 게시물을 모두 +1 하기 
		boardMapper.bstepUp(bdto);
		
		//답변달기 저장
		boardMapper.insertBreply(bdto);
	}

}