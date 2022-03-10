package com.jaego.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaego.web.dto.FindDto;
import com.jaego.web.dto.LoginDto;
import com.jaego.web.dto.MemberDto;
import com.jaego.web.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {	
		this.memberDao = memberDao;
	}
	
	// 회원가입 회원 정보 등록(insert)
	@Override
	public void insert(MemberDto memberDto) {
		memberDao.insert(memberDto);
	}
	
	// 이메일 중복 체크
	@Override
	public int checkEmail(String email1, String email2) {
		return memberDao.checkEmail(email1, email2);
	}
	
	// 로그인
	@Override
	public MemberDto login(LoginDto loginDto) {
		return memberDao.login(loginDto);
	}
	
	// 이메일 찾기
	@Override
	public FindDto findEmail(FindDto findDto) {
		return memberDao.findEmail(findDto);
	}
	
	// 비밀번호 찾기
	@Override
	public void findPassword(FindDto findDto) {
		memberDao.findPassword(findDto);
	}
	
	// 프로필 조회
	@Override
	public MemberDto myProfile(int memId) {
		return memberDao.myProfile(memId);
	}
	
	
	
	
	
	// 특정 회원 정보 전체 조회
	@Override
	public List<MemberDto> selectByMemId(int memId) {
		return memberDao.selectByMemId(memId);
	}
	
	// 회원 정보 수정
	@Override
	public int update(MemberDto memberDto) {
		return memberDao.update(memberDto);
	}
	
	// 회원 정보 수정(멘토 여부-멘토 승인됨)
	@Override
	public int updateMentorStatus(int memId) {
		return memberDao.updateMentorStatus(memId);
	}
	// 회원 정보 수정(관리자 여부-관리자임)
	@Override
	public int updateAuthStatus(int memId) {
		return memberDao.updateAuthStatus(memId);
	}
	
	// 회원 정보 삭제
	@Override
	public int delete(int memId) {
		return memberDao.delete(memId);
	}


	

}
