package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.ShopDto;
import com.java.repository.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired ShopRepository shopRepository;
	
	//전체 상품리스트 정렬
	@Override
	public List<ShopDto> findAll() {
		List<ShopDto> list = shopRepository.findAll();
		return list;
	}

}