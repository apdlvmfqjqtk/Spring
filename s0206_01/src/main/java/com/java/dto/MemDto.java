package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemDto {
	
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;
	private String hobby;
	
	
//	빌더선언하면 맘대로 부분선언가능
//	public MemDto(String id, String name) {
//		this.id = id;
//		this.pw = pw;
//	}
	
	
	
	
//	public MemDto() {} //@NoArgsConstructor
//
//	// @AllArgsConstructor
//	public MemDto(String id, String pw, String name, String tel, String gender, String hobby) {
//		super();
//		this.id = id;
//		this.pw = pw;
//		this.name = name;
//		this.tel = tel;
//		this.gender = gender;
//		this.hobby = hobby;
//	}
	
	
	
	
}