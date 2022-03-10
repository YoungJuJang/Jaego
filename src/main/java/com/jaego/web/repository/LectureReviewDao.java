package com.jaego.web.repository;

import java.util.List;


import org.springframework.stereotype.Repository;
import com.jaego.web.dto.LectureReviewDto;
import com.jaego.web.util.PageMakers;

@Repository
public interface LectureReviewDao {

	public abstract void insert(LectureReviewDto lectureReviewDto);
	public void delete(int reviewId);
	public abstract String selectTitle(int lectureId);
	public abstract int update(LectureReviewDto lectureReviewDto);
	public abstract List<LectureReviewDto> reviewList(PageMakers pageMakers);
	public abstract LectureReviewDto select(int reviewId);
	public abstract int reviewTotalCount(PageMakers pageMakers);
}
