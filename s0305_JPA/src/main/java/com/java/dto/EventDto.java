package com.java.dto;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude = "clist") //무한루프 방지, json데이터호출 : @JsonIgnore
public class EventDto {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //DB에 있는 시퀀스를 사용
	private int eno;
	@Column(nullable = false, length = 100)
	private String etitle;
	@Lob  // 대용량 문자 형태
	private String econtent;
	
	@ManyToOne(fetch = FetchType.EAGER) //여러명이 하나의글쓸수있다, EAGER = 즉시가져옴 (default값)
	@JoinColumn(name="id")  // name 변경가능 - 닉네임 (ex)eventDtoID)
	private MemberDto memberDto;
	@ColumnDefault("0") //문자 : " ' ' ", 숫자 : ""
	private int ehit;	
	@UpdateTimestamp
	private Timestamp edate;
	private String efile;
	private String efile2;
	private Timestamp stdate;
	private Timestamp enddate;
	private int openchk;

	@OneToMany(mappedBy = "eventDto", fetch = FetchType.EAGER)
	private List<CboardDto2> clist;
}