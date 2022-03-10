package com.jaego.web.dto;

import org.apache.ibatis.type.Alias;

@Alias(value="lectureImgDto")
public class LectureImgFileDto {
	
	private int lectureImgId; //lecture image파일 고유번호 (프라이머리키/시퀀스)
	private int lectureId; //lecture 고유 번호 (외래키)
	private String lectureImg; //lecture 이미지파일명;
	
	public LectureImgFileDto() {
		super();
	
	}
	public int getLectureImgId() {
		return lectureImgId;
	}
	public void setLectureImgId(int lectureImgId) {
		this.lectureImgId = lectureImgId;
	}
	public int getLectureId() {
		return lectureId;
	}
	public void setLectureId(int lectureId) {
		this.lectureId = lectureId;
	}
	public String getLectureImg() {
		return lectureImg;
	}
	public void setLectureImg(String lectureImg) {
		this.lectureImg = lectureImg;
	}
	
	
	

}
