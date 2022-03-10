package com.jaego.web.service;

import java.util.List;
import java.util.Map;

import com.jaego.web.dto.MentorDto;

public interface MentorService {
	public abstract List<MentorDto> list(Map<String, Object> mentorMap);
	
	// 멘토 정보 추가 
	public abstract void add(MentorDto mentorDto);
	
	public abstract MentorDto selectByMemberId(int mId);
	
	// 멘토 정보 삭제
	public abstract int delete(MentorDto mentorDto);

	public abstract MentorDto selectByMemberName(String memberName);

}

