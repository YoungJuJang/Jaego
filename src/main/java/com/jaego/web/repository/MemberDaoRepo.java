package com.jaego.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaego.web.dto.FindDto;
import com.jaego.web.dto.LoginDto;
import com.jaego.web.dto.MemberDto;

@Repository
public class MemberDaoRepo implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoRepo(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	

	// 회원가입 회원 정보 등록(insert)
	@Override
	public void insert(MemberDto memberDto) {
		sqlSessionTemplate.insert("register", memberDto);
	}
	
	//이메일 중복체크
	@Override
	public int checkEmail(String email1, String email2) {
		Map<String,Object> checkMap = new HashMap<>();
		checkMap.put("memberEmail1", email1);
		checkMap.put("memberEmail2", email2);
		return sqlSessionTemplate.selectOne("checkEmail",checkMap);
	}
	
	//로그인
	@Override
	public MemberDto login(LoginDto loginDto) {
		return sqlSessionTemplate.selectOne("login", loginDto);
	}
	
	// 이메일 찾기
	@Override
	public FindDto findEmail(FindDto findDto) {
		return sqlSessionTemplate.selectOne("findEmail", findDto);
	}

	// 비밀번호 찾기(새로운 비밀번호로 변경)
	@Override
	public void findPassword(FindDto findDto) {
		sqlSessionTemplate.update("findPassword", findDto);
	}
	
	// 회원 정보 수정(update)
	@Override
	public int update(MemberDto memberDto) {
		return sqlSessionTemplate.update("update", memberDto);
	}
	
	// 프로필 조회
	@Override
	public MemberDto myProfile(int memId) {
		return sqlSessionTemplate.selectOne("selectByMemId",memId);
	}
	
	
	

	
	
	// 임시로 특정 회원 정보 전체 조회(select)
	@Override
	public List<MemberDto> selectByMemId(int memId) {
		return sqlSessionTemplate.selectList("selectByMemId", memId);
	}
	
	
	
	// 회원 정보 수정(멘토 여부-멘토 승인됨, 관리자 여부-관리자임)
	@Override
	public int updateMentorStatus(int memId) {
		return sqlSessionTemplate.update("updateMentorStatus", memId);
	}

	@Override
	public int updateAuthStatus(int memId) {
		return sqlSessionTemplate.update("updateAuthStatus", memId);
	}
	
	// 회원 정보 삭제(delete)
	@Override
	public int delete(int memId) {
		return sqlSessionTemplate.delete("delete", memId);
	}


	







}
