package com.jaego.web.service;

import java.util.List;


import org.springframework.stereotype.Service;
import com.jaego.web.dto.LectureReviewDto;
import com.jaego.web.util.PageMaker;
import com.jaego.web.util.PageMakers;


@Service
public interface LectureReviewService {
	
	public void insert(LectureReviewDto lecturereviewDto);
	public void delete(int reviewId);
	public abstract String selectTitle(int lectureId);
	public int update(LectureReviewDto lecturereviewDto);
	public List<LectureReviewDto> reviewList(PageMakers pageMakers);
	public abstract LectureReviewDto read(int reviewId);
	public abstract int reviewTotalCount(PageMakers pageMakers);

}
