package com.jaego.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jaego.web.dto.LectureReviewDto;
import com.jaego.web.repository.LectureReviewDao;
import com.jaego.web.util.PageMaker;
import com.jaego.web.util.PageMakers;

@Service
public class LectureReviewServiceImpl implements LectureReviewService {

	@Autowired
	private LectureReviewDao lectureReviewDao;
	

	public LectureReviewDao getLectureReviewDao() {
		return lectureReviewDao;
	}

	public void setLectureReviewDao(LectureReviewDao lectureReviewDao) {
		lectureReviewDao = lectureReviewDao;
	}

	@Override
	public void insert(LectureReviewDto lecturereviewDto) {
		lectureReviewDao.insert(lecturereviewDto);
		
	}

	

	@Override
	public int update(LectureReviewDto lecturereviewDto) {
		return lectureReviewDao.update(lecturereviewDto);
		
	}

	

	@Override
	public LectureReviewDto read(int reviewId) {
		return lectureReviewDao.select(reviewId);
	}

	@Override
	public void delete(int reviewId) {
		lectureReviewDao.delete(reviewId);
		
	}

	@Override
	public String selectTitle(int lectureId) {
		return lectureReviewDao.selectTitle(lectureId);
	}

	@Override
	public int reviewTotalCount(PageMakers pageMakers) {
		return lectureReviewDao.reviewTotalCount(pageMakers);
	}

	@Override
	public List<LectureReviewDto> reviewList(PageMakers pageMakers) {
		return lectureReviewDao.reviewList(pageMakers);
	}
	
	

}
