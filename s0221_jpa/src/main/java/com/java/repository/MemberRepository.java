package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.dto.MemberDto;

//<리턴타입, primary key 타입>
public interface MemberRepository extends JpaRepository<MemberDto, String> {

	//selext * from memberdto where id=#{id} and pw=#{pw};
	MemberDto findByIdAndPw(String id, String pw);
	

}
