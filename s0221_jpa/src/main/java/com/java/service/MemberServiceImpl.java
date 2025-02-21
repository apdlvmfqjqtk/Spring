package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.MemberDto;
import com.java.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired MemberRepository memberRepository;
	
	@Override
	public void save(MemberDto mdto) {
		memberRepository.save(mdto); // 자동으로 저장,  mapper.xml이 필요없어짐
	}

	@Override
	public List<MemberDto> FimdAll() {
		List<MemberDto> list = memberRepository.findAll();
		return list;
	}

	@Override
	public MemberDto FindbyId(String id) {
		//findById -> 검색결과가 없을경우 에러처리해야함
		//select * from memberdto where id = #{id};
		//findByIdAndPw는
		// select * from memberdto where id=#{id} and pw=#{pw}; 와 같다		
		
		MemberDto memberDto = memberRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("데이터 에시처리");
				});
		return memberDto;
	}

	@Override //회원정보삭제
	public void deleteById(String id) {
		memberRepository.deleteById(id);
	}

	@Override //로그인
	public MemberDto FindbyIdAndPw(String id, String pw) {
		MemberDto memberDto = memberRepository.findByIdAndPw(id,pw);
		return memberDto;
	}

}