package com.jaego.web.repository;

import java.util.List;
import java.util.Map;

import com.jaego.web.dto.MentorDto;

public interface MentorDao {
	public abstract List<MentorDto> list(Map<String, Object> mentorMap); // 모든 멘토들 조회
	public abstract void insertMentor(MentorDto mentorDto); // 멘토 정보를 추가
	public abstract MentorDto selectByMemberId(int memberId); // 멤버 아이디로 멘토 조회
	
	public abstract MentorDto selectByMentorId(int mentorId); // 멘토 아이디로 멘토 조회

	public abstract int update(MentorDto mentorDto); // 멘토 정보 수정
	public abstract int delete(MentorDto mentorDto); // 멘토 삭제
}
