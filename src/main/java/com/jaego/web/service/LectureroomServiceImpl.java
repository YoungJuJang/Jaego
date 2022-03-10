package com.jaego.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaego.web.repository.LectureroomDao;
import com.jaego.web.util.PageMaker;
import com.jaego.web.dto.LectureroomDto;

@Service
public class LectureroomServiceImpl implements LectureroomService {
	@Autowired
	private LectureroomDao lectureroomDao;
	
	public void setLectureroomDao(LectureroomDao lectureroomDao) {
		this.lectureroomDao = lectureroomDao;
	}
	
	@Override
	public List<LectureroomDto> lectureroomList(PageMaker  pageMaker){
		return lectureroomDao.lectureroomList(pageMaker);
	}
	
	@Override
	public List<LectureroomDto> selectMemberId(int lectureId) {
		return lectureroomDao.selectMemberId(lectureId);
	}
	

	@Override
	public int delete(int lectureroomId) {
		return lectureroomDao.delete(lectureroomId);
	}

	@Override
	public int edit(LectureroomDto lectureroomDto) {
		return lectureroomDao.update(lectureroomDto);
	}
	
	@Override
	public void write(LectureroomDto lectureroomDto) {
		// TODO Auto-generated method stub
		lectureroomDao.insert(lectureroomDto);
	}

	@Override
	public LectureroomDto select(int lectureroomId) {
		return lectureroomDao.select(lectureroomId);
	}

	@Override
	public void reply(LectureroomDto lectureroomDto) {
		lectureroomDao.replyinsert(lectureroomDto);
	}

	@Override
	public int lectureroomTotalCount(PageMaker pageMaker) {
		return lectureroomDao.lectureroomTotalCount(pageMaker);
	}
	
	

}
