package com.jaego.web.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaego.web.dto.LectureroomDto;
import com.jaego.web.util.PageMaker;

@Repository
public class LectureroomDaoRepo implements LectureroomDao{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public LectureroomDaoRepo(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<LectureroomDto> lectureroomList(PageMaker  pageMaker) {
		return sqlSessionTemplate.selectList("lectureroomList",pageMaker);
	}

	@Override
	public List<LectureroomDto> selectMemberId(int lectureId) {
		return sqlSessionTemplate.selectList("selectMemberId", lectureId);
	}

	@Override
	public void insert(LectureroomDto lectureroomDto) {
		sqlSessionTemplate.insert("insert", lectureroomDto);
	}
	
	@Override
	public int delete(int lectureroomId) {
		return sqlSessionTemplate.delete("lectureroomDao.delete", lectureroomId);
	}
	
	@Override
	public int deleteAll() {
		return sqlSessionTemplate.delete("deleteAll");
	}

	@Override
	public int update(LectureroomDto lectureroomDto) {
		return sqlSessionTemplate.update("lectureroomDao.update", lectureroomDto);
	}
	
	@Override
	public LectureroomDto select(int lectureroomId) {
//		LectureroomDto dto = (LectureroomDto) sqlSessionTemplate.selectOne("select", lectureroomDto);
//		return dto;
		return sqlSessionTemplate.selectOne("select", lectureroomId);
	}
	
	@Override
	public void replyinsert(LectureroomDto lectureroomDto) {
		sqlSessionTemplate.insert("replyinsert", lectureroomDto);
	}

	@Override
	public int lectureroomTotalCount(PageMaker pageMaker) {
		return sqlSessionTemplate.selectOne("lectureroomTotalCount" , pageMaker);
	}
	
	
}
