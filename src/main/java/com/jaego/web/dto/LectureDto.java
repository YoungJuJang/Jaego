package com.jaego.web.dto;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias(value = "lectureDto")
public class LectureDto {
	private int lectureId; // lecture 고유번호(프라이머리 키/시퀀스)
	private int mentorId; // mentor 고유번호 (외래키)
	private int memberId; //member 고유번호 (외래키)
	private String lectureTitle; // lecture 제목
	private String lectureContent; // lecture 내용
	private int lecturePrice; // lecture 판매가격
	private Date lectureStart; // lecture 시작 날짜
	private Date lectureEnd; // lecture 끝 날짜
	private String lectureCategory; // lecture 카테고리
	private String lectureZipcode; // lecture 장소 우편번호
	private String lectureRoadAddress; // lecture 장소 도로명 주소
	private String lectureJibunAddress; // lecture 장소 지번
	private String lectureNamugiAddress; // lecture 장소 나머지 주소
	private Date lectureRegdate; // lecture 창설 날짜
	private String lectureMaxcount; // lecture 최대 인원
	private int lectureStatus; // lecture 승인여부
	
	public int getLectureId() {
		return lectureId;
	}
	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}
	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public int getmemberId() {
		return memberId;
	}
	public void setmemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public String getLectureContent() {
		return lectureContent;
	}
	public void setLectureContent(String lectureContent) {
		this.lectureContent = lectureContent;
	}
	public int getLecturePrice() {
		return lecturePrice;
	}
	public void setLecturePrice(int lecturePrice) {
		this.lecturePrice = lecturePrice;
	}
	public Date getLectureStart() {
		return lectureStart;
	}
	public void setLectureStart(Date lectureStart) {
		this.lectureStart = lectureStart;
	}
	public Date getLectureEnd() {
		return lectureEnd;
	}
	public void setLectureEnd(Date lectureEnd) {
		this.lectureEnd = lectureEnd;
	}
	public String getLectureCategory() {
		return lectureCategory;
	}
	public void setLectureCategory(String lectureCategory) {
		this.lectureCategory = lectureCategory;
	}
	public String getLectureZipcode() {
		return lectureZipcode;
	}
	public void setLectureZipcode(String lectureZipcode) {
		this.lectureZipcode = lectureZipcode;
	}
	public String getLectureRoadAddress() {
		return lectureRoadAddress;
	}
	public void setLectureRoadAddress(String lectureRoadAddress) {
		this.lectureRoadAddress = lectureRoadAddress;
	}
	public String getLectureJibunAddress() {
		return lectureJibunAddress;
	}
	public void setLectureJibunAddress(String lectureJibunAddress) {
		this.lectureJibunAddress = lectureJibunAddress;
	}
	public String getLectureNamugiAddress() {
		return lectureNamugiAddress;
	}
	public void setLectureNamugiAddress(String lectureNamugiAddress) {
		this.lectureNamugiAddress = lectureNamugiAddress;
	}
	public Date getLectureRegdate() {
		return lectureRegdate;
	}
	public void setLectureRegdate(Date lectureRegdate) {
		this.lectureRegdate = lectureRegdate;
	}
	public String getLectureMaxcount() {
		return lectureMaxcount;
	}
	public void setLectureMaxcount(String lectureMaxcount) {
		this.lectureMaxcount = lectureMaxcount;
	}
	public int getLectureStatus() {
		return lectureStatus;
	}
	public void setLectureStatus(int lectureStatus) {
		this.lectureStatus = lectureStatus;
	}

	

}
