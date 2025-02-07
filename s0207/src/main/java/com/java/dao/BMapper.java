package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;

	//@Repository // 원래 Dao(DB)는 Repository 써야함

@Mapper // Mybatis는 Mapper라는 형태로 사용
public interface BMapper {

	ArrayList<BoardDto> blist();

}