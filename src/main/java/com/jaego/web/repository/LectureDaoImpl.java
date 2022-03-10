package com.jaego.web.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaego.web.dto.LectureDto;
import com.jaego.web.dto.LectureImgFileDto;



@Repository
public class LectureDaoImpl implements LectureDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public LectureDaoImpl (SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	
	@Override
	public List<LectureDto> selectAll(int start, int pageSize) {
		Map<String,Integer> paging = new HashMap<>();
		paging.put("start", start);
		paging.put("pageSize", pageSize);

		return sqlSessionTemplate.selectList("selectAll",paging);
	}
	

	@Override
	public LectureDto view(int lectureId) {
		return sqlSessionTemplate.selectOne("view",lectureId);

	}



	@Override
	public int lectureCount() {
		return  sqlSessionTemplate.selectOne("lectureCount");
	}
	

	@Override
	public int insertLecture( Map<String,Object> lectureMap) {
		 sqlSessionTemplate.insert("insertLecture",lectureMap);		
		 int lectureId = (int) lectureMap.get("lectureId");
		return lectureId;
		
	}

	@Override
	public void insertLectureImgFile(List<LectureImgFileDto> fileDto) {
		sqlSessionTemplate.insert("insertLectureImgFile",fileDto);			
	}


	@Override
	public int selectLectureId(Map<String, Object> lectureMap) {
		return 	sqlSessionTemplate.selectOne("selectLectureId",lectureMap);			

	}


	@Override
	public LectureDto selectLecture(int mId) {
		return  sqlSessionTemplate.selectOne("selectLecture",mId);
	}


	@Override
	public List<LectureImgFileDto> selectLectureImgFile(int lId) {
		return sqlSessionTemplate.selectList("selectLectureImgFile",lId);
	}


	@Override
	public List<LectureDto> myOrderLecture(int memId) {
		return sqlSessionTemplate.selectList("myOrderLecture",memId);
	}


	@Override
	public LectureImgFileDto myOrderLectureImg(int lectureId) {
		return sqlSessionTemplate.selectOne("myOrderLectureImg",lectureId);
	}


	@Override
	public List<LectureDto> searchLecture(String lectureTitle) {
		return sqlSessionTemplate.selectList("searchLecture",lectureTitle);
	}


	@Override
	public List<LectureDto> categoryLecture(String lectureCategory) {
		return sqlSessionTemplate.selectList("categoryLecture",lectureCategory);
	}


	@Override
	public List<String> lectureTitle(String lectureTitle) {
		ArrayList titleList = (ArrayList) sqlSessionTemplate.selectList("lectureTitle",lectureTitle);
		return titleList;
	
	}
}