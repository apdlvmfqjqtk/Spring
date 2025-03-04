package com.java.service;

import java.util.List;

import com.java.dto.ShopDto;

public interface ShopService {
	
	//전체 상품리스트
	List<ShopDto> findAll();

}