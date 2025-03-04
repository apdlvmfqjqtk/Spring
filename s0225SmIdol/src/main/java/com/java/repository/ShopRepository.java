package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.ShopDto;

public interface ShopRepository extends JpaRepository<ShopDto, Integer>{

}