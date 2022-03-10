package com.jaego.web.repository;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaego.web.dto.LectureReviewDto;
import com.jaego.web.util.PageMakers;

@Repository
public class LectureReviewDaoImpl implements LectureReviewDao {
	
	@Autowired
	public SqlSessionTemplate sqlSessionTemplate;
	
	public LectureReviewDaoImpl(SqlSessionTemplate sqlSessiongTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insert(LectureReviewDto lectureReviewDto) {
		sqlSessionTemplate.insert("inserts",lectureReviewDto);
		
	}

	
	
	@Override
	public int update(LectureReviewDto lectureReviewDto) {
		return sqlSessionTemplate.update("updates",lectureReviewDto);
	}

	@Override
	public List<LectureReviewDto> reviewList(PageMakers pageMakers) {
		return sqlSessionTemplate.selectList("reviewList",pageMakers);
	}

	@Override
	public LectureReviewDto select(int reviewId) {
		LectureReviewDto dto = (LectureReviewDto) sqlSessionTemplate.selectOne("selects", reviewId);
		return dto;
	}

	@Override
	public void delete(int reviewId) {
		sqlSessionTemplate.delete("deletes",reviewId);
	}
	
	@Override
	public String selectTitle(int lectureId) {
		return sqlSessionTemplate.selectOne("selectTitle", lectureId);
	}

	@Override
	public int reviewTotalCount(PageMakers pageMakers) {
		return sqlSessionTemplate.selectOne("reviewTotalCount" , pageMakers);
	}
	
	

}
