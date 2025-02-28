package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java.dto.BoardDto;

public interface BoardRepository extends JpaRepository<BoardDto, Integer>{

	// select * from boaarddto where btitle like '%제목%'
	List<BoardDto> findByBtitleContaining(String search);
//	@Query(value = "select * from boarddto where btitle like %:search% or bcontent like %:abc%")

	
	//Memberdto 로그인부분 쿼리
//	@Query(value = "select * from memberdto where id=? and pw=?",
//			nativeQuery = true)
//	Optional<MemberDto> findByIdAndPw(String id,String pw);
	
//	@Query(value = "select * from boarddto order by bgroup desc, bstep asc",
//			nativeQuery = true)
//	Page<BoardDto> findAll(pageable);
}