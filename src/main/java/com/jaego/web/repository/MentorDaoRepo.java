package com.jaego.web.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaego.web.dto.MentorDto;

@Repository
public class MentorDaoRepo implements MentorDao{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	public MentorDaoRepo(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<MentorDto> list(Map<String, Object> mentorMap) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("list", mentorMap);
	}

	@Override
	public void insertMentor(MentorDto mentorDto) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("insertMentor", mentorDto);
		
	}

	@Override
	public MentorDto selectByMemberId(int mId){
		MentorDto dto = (MentorDto) sqlSessionTemplate.selectOne("selectByMemberId", mId);
		return dto;
	}
	
	@Override
	public MentorDto selectByMentorId(int mentorId) {
		MentorDto dto =(MentorDto) sqlSessionTemplate.selectOne("selectByMentorId", mentorId);
		return dto;
	}

	@Override
	public int update(MentorDto mentorDto) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.update("update",mentorDto);
	}

	@Override
	public int delete(MentorDto mentorDto) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.delete("delete", mentorDto);
	}



}