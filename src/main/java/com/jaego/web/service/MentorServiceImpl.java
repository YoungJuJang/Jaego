package com.jaego.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaego.web.dto.MentorDto;
import com.jaego.web.repository.MentorDao;

@Service
public class MentorServiceImpl implements MentorService{
	@Autowired
	private MentorDao mentorDao;
	


	public void setMentorDao(MentorDao mentorDao) {
		this.mentorDao = mentorDao;
	}

	@Override
	public List<MentorDto> list(Map<String, Object> mentorMap) { 
		// TODO Auto-generated method stub
		return mentorDao.list(mentorMap);
	}

	@Override
	public void add(MentorDto mentorDto) {
		// TODO Auto-generated method stub
		mentorDao.insertMentor(mentorDto);
	}

	@Override
	public MentorDto selectByMemberId(int mId) {
		// TODO Auto-generated method stub
		return mentorDao.selectByMemberId(mId);
	}

	@Override
	public int delete(MentorDto mentorDto) {
		// TODO Auto-generated method stub
		return mentorDao.delete(mentorDto);
	}

	@Override
	public MentorDto selectByMemberName(String memberName) {
		// TODO Auto-generated method stub
		return null;
	}
}
