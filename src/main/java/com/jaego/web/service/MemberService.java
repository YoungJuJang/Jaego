package com.jaego.web.service;

import java.util.List;

import com.jaego.web.dto.FindDto;
import com.jaego.web.dto.LoginDto;
import com.jaego.web.dto.MemberDto;

public interface MemberService {
	
	// 회원가입 회원 정보 등록(insert)
	public abstract void insert(MemberDto memberDto);
	
	// 이메일 중복체크
	public abstract int checkEmail(String email1,String email2);
	
	// 로그인
	public abstract MemberDto login(LoginDto loginDto);	
	
	// 이메일 찾기 
	public abstract FindDto findEmail(FindDto findDto); 
	
	// 비밀번호 찾기
	public abstract void findPassword(FindDto findDto); 

	// 프로필 조회
	public abstract MemberDto myProfile(int memId);
	
	
	
	// 임시로 특정 회원 정보 전체 조회
	public abstract List<MemberDto> selectByMemId(int memId);
	
	// 회원 정보 수정
	public abstract int update(MemberDto memberDto);
	
	// 회원 정보 수정(멘토 여부-멘토 승인됨, 관리자 여부-관리자임)
	public abstract int updateMentorStatus(int memId);
	public abstract int updateAuthStatus(int memId);
	
	// 회원 정보 삭제
	public abstract int delete(int memId);
}

