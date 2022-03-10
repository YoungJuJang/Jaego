package com.jaego.web.service;

import java.util.List;

import com.jaego.web.dto.LectureroomDto;
import com.jaego.web.util.PageMaker;

public interface LectureroomService {
	public abstract List<LectureroomDto> lectureroomList(PageMaker  pageMaker);
	
	public abstract List<LectureroomDto> selectMemberId(int lectureId);
	
	public abstract void write(LectureroomDto lectureroomDto);

	public abstract LectureroomDto select(int lectureroomId);
	
	public abstract int delete(int lectureroomId);

	public abstract int edit(LectureroomDto lectureroomDto);

	public abstract void reply(LectureroomDto lectureroomDto);

	public abstract int lectureroomTotalCount(PageMaker pageMaker);
}
