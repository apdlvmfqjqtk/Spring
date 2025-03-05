package com.java.service;

import java.util.List;

import com.java.dto.ShopDto;

public interface ShopService {
	
	//전체 상품리스트
	List<ShopDto> findAll();

	//가수 상품 전체
	List<ShopDto> findByNo(int artist_no);





}