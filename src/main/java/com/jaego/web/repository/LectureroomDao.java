package com.jaego.web.repository;

import java.util.List;

import com.jaego.web.dto.LectureroomDto;
import com.jaego.web.dto.MentorDto;
import com.jaego.web.util.PageMaker;

public interface LectureroomDao {
	public abstract List<LectureroomDto> lectureroomList(PageMaker  pageMaker);

	public abstract void insert(LectureroomDto lectureroomDto);

	public abstract LectureroomDto select(int lectureroomId);
	
	public abstract List<LectureroomDto> selectMemberId(int lectureId);
	
	public abstract int delete(int lectureroomId);

	public abstract int deleteAll();

	public abstract int update(LectureroomDto lectureroomDto);

	public abstract void replyinsert(LectureroomDto lectureroomDto);

	public abstract int lectureroomTotalCount(PageMaker pageMaker);
}
