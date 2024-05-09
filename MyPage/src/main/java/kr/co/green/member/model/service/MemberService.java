package kr.co.green.member.model.service;

import kr.co.green.member.model.dto.Member;

public interface MemberService {
//	회원가입
	public int register(Member member);
	
//	로그인
	public Member login(Member member);
	
	
//	회원 수정
}