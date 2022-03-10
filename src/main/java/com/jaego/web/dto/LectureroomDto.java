package com.jaego.web.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias(value = "LectureroomDto")
public class LectureroomDto {
	private int rownum; 
	private int memberId; 
	private int lectureroomId;
	private int lectureId;
	private int mentorStatus;
	private String lectureroomWriter; // 게시글 작성자
	private String lectureroomTitle; // 게시글 제목
	private String lectureroomContent; // 게시글 내용
	private Timestamp lectureroomRegdate; // 게시글 등록 날짜
	private String lectureroomFname; // 파일 이름
	private String lectureroomPassword; // 게시글 비밀번호

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getLectureroomId() {
		return lectureroomId;
	}

	public void setLectureroomId(int lectureroomId) {
		this.lectureroomId = lectureroomId;
	}

	public int getLectureId() {
		return lectureId;
	}

	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}

	public int getMentorStatus() {
		return mentorStatus;
	}

	public void setMentorStatus(int mentorStatus) {
		this.mentorStatus = mentorStatus;
	}

	public String getLectureroomWriter() {
		return lectureroomWriter;
	}

	public void setLectureroomWriter(String lectureroomWriter) {
		this.lectureroomWriter = lectureroomWriter;
	}

	public String getLectureroomTitle() {
		return lectureroomTitle;
	}

	public void setLectureroomTitle(String lectureroomTitle) {
		this.lectureroomTitle = lectureroomTitle;
	}

	public String getLectureroomContent() {
		return lectureroomContent;
	}

	public void setLectureroomContent(String lectureroomContent) {
		this.lectureroomContent = lectureroomContent;
	}


	public Timestamp getLectureroomRegdate() {
		return lectureroomRegdate;
	}

	public void setLectureroomRegdate(Timestamp lectureroomRegdate) {
		this.lectureroomRegdate = lectureroomRegdate;
	}

	public String getLectureroomFname() {
		return lectureroomFname;
	}

	public void setLectureroomFname(String lectureroomFname) {
		this.lectureroomFname = lectureroomFname;
	}

	public String getLectureroomPassword() {
		return lectureroomPassword;
	}

	public void setLectureroomPassword(String lectureroomPassword) {
		this.lectureroomPassword = lectureroomPassword;
	}




}
