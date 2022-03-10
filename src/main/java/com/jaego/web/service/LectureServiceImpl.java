package com.jaego.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaego.web.dto.LectureDto;
import com.jaego.web.dto.LectureImgFileDto;
import com.jaego.web.dto.MentorDto;
import com.jaego.web.repository.LectureDao;
import com.jaego.web.repository.MentorDao;

@Service
public class LectureServiceImpl implements LectureService{

	@Autowired
	LectureDao lectureDao;
	
	@Autowired
	MentorDao mentorDao;
	
	public void setLectureDao(LectureDao lectureDao) {
		this.lectureDao = lectureDao;
	}

	

	@Override
	public List<LectureDto> selectAll(int start, int pageSize) {
		return lectureDao.selectAll(start,pageSize);
	}
	

	@Override
	public Map<String, Object>  view(int lectureId) {
		Map<String, Object> viewInfo = new HashMap<String,Object>();
		LectureDto viewLecture =lectureDao.view(lectureId);
		try {
			List<LectureImgFileDto> viewLectureImg = lectureDao.selectLectureImgFile(lectureId);
			MentorDto viewMentor = mentorDao.selectByMentorId(viewLecture.getMentorId());
			viewInfo.put("viewLecture", viewLecture);
			viewInfo.put("viewLectureImg", viewLectureImg);
			viewInfo.put("viewMentor", viewMentor);

		}catch(NullPointerException e) {
			return null;
		}	
		
		return viewInfo;
	}

	
	@Override
	public int insertLecture(Map<String,Object> lectureMap) {
		return lectureDao.insertLecture(lectureMap);
		
	}

	@Override
	public int selectLectureId(Map<String, Object> lectureMap){
		return lectureDao.selectLectureId(lectureMap);
	}

	@Override
	public void insertLectureImgFile(List<LectureImgFileDto> fileDto) {
		lectureDao.insertLectureImgFile(fileDto);

	}

	@Override
	public Map<String, Object> selectMyLecture(int mId) {
		Map<String, Object> myLectureInfo = new HashMap<String,Object>();
		LectureDto myLecture = lectureDao.selectLecture(mId);
		try {
			
			List<LectureImgFileDto> myLectureImg = lectureDao.selectLectureImgFile(myLecture.getLectureId());
			myLectureInfo.put("myLecture", myLecture);
			myLectureInfo.put("myLectureImg", myLectureImg);
		}catch(NullPointerException e) {
			return null;
		}
		
		
		
		return myLectureInfo;
	}

	@Override
	public int lectureCount() {
		return lectureDao.lectureCount();
	}



	@Override
	public List<LectureDto> myOrderLecture(int memId) {
		return lectureDao.myOrderLecture(memId);
	}



	@Override
	public LectureImgFileDto myOrderLectureImg(int lectureId) {
		return lectureDao.myOrderLectureImg(lectureId);
	}



	@Override
	public List<LectureDto> searchLecture(String lectureTitle) {
		return lectureDao.searchLecture(lectureTitle);
	}



	@Override
	public List<LectureDto> categoryLecture(String lectureCategory) {
		return lectureDao.categoryLecture(lectureCategory);
	}



	@Override
	public List<String> lectureTitle(String lectureTitle) {
		return lectureDao.lectureTitle(lectureTitle);
	}




}
