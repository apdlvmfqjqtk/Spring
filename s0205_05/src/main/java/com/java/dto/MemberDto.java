package com.java.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

//@Getter  //게터
//@Setter // 세터
@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 기본생성자
@Data // 게터세터 둘 다 포함
public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String tel;
	private String gender;	
	private String hobby;	
}