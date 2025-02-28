package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicInsert
@Entity
public class MemberDto {

	@Id
	@Column(length=100)
	private String id;
	@Column(nullable = false, length = 100)
	private String pw;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(length = 20)
	private String phone;
	@ColumnDefault("'남자'") //기본으로 정해질 값
	private String gender;
	@Column(length = 100)
	private String hobby;
	// @CreateionTimestamp // 최초간자동입력 - sysdate
	@UpdateTimestamp // 업데이트 시간 추가
	private Timestamp mdate;
	
}