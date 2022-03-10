package com.jaego.web.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias(value = "LectureReviewDto")
public class LectureReviewDto {
	private int rownum;
	private int reviewId;
	private int lectureId;
	private int memberId;
	private String reviewWriter;
	private String reviewContent;
	private int reviewScore;
	private Date reviewRegdate;
	private String title;
	
	
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getLectureId() {
		return lectureId;
	}
	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getReviewWriter() {
		return reviewWriter;
	}
	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public int getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}
	public Date getReviewRegdate() {
		return reviewRegdate;
	}
	public void setReviewRegdate(Date reviewRegdate) {
		this.reviewRegdate = reviewRegdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
