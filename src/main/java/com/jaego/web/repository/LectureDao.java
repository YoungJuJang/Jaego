package com.jaego.web.repository;

import java.util.List;
import java.util.Map;

import com.jaego.web.dto.LectureDto;
import com.jaego.web.dto.LectureImgFileDto;

public interface LectureDao {
	
	public abstract List<LectureDto> selectAll(int start, int pageSize);
	public abstract int lectureCount();
	
	public abstract LectureDto view(int lectureId); // vod/view.jsp를 위한 함수
	
	
	public abstract int insertLecture(Map<String,Object> lectureMap);
	public abstract int selectLectureId(Map<String,Object> lectureMap);
	public abstract void insertLectureImgFile(List<LectureImgFileDto> fileDto);
	public abstract LectureDto selectLecture(int mId);
	public abstract List<LectureImgFileDto> selectLectureImgFile(int lId);

	public abstract List<LectureDto> myOrderLecture(int memId);
	public abstract LectureImgFileDto myOrderLectureImg(int lectureId);
	
	public abstract List<String> lectureTitle(String lectureTitle);
	public abstract List<LectureDto> searchLecture(String lectureTitle);
	public abstract List<LectureDto> categoryLecture(String lectureCategory);
	
	
}
