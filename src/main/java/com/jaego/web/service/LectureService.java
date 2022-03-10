package com.jaego.web.service;

import java.util.List;
import java.util.Map;

import com.jaego.web.dto.LectureDto;
import com.jaego.web.dto.LectureImgFileDto;



public interface LectureService {
	
	public abstract List<LectureDto> selectAll(int start, int pageSize);
	public abstract int lectureCount();
	public abstract Map<String, Object>view(int lectureId);
	public abstract int insertLecture(Map<String,Object> lectureList);
	public abstract void insertLectureImgFile(List<LectureImgFileDto> fileDto);
	public abstract int selectLectureId(Map<String,Object> lectureMap);
	public abstract Map<String,Object> selectMyLecture(int mId);
	public abstract List<LectureDto> myOrderLecture(int memId);
	public abstract LectureImgFileDto myOrderLectureImg(int lectureId);

	public abstract List<LectureDto> searchLecture(String lectureTitle);
	public abstract List<LectureDto> categoryLecture(String lectureCategory);
	public abstract List<String> lectureTitle(String lectureTitle);
}
