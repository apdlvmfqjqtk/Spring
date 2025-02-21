package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamicInsert // 데이터값이 null인 경우 컬럼에서 제외
@Builder 			// 부분 생성자
@AllArgsConstructor	// 전체 생성자
@NoArgsConstructor  // 기본 생성자
@Data // @Setter + @Gettrt\
@Entity
public class MemberDto {
	
	@Id
	@Column(length=100)
	private String id;
	@Column(nullable = false, length=100)
	private String pw;
	@Column(nullable = false, length=50)
	private String name;
	@Column(length=20)
	private String phone;
	@ColumnDefault(" '남자' ")
	private String gender;
	@Column(length=100)
	private String hobby;
	@CreationTimestamp
	private Timestamp mdate;
	
}