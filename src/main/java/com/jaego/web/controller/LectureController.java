package com.jaego.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jaego.web.dto.LectureDto;
import com.jaego.web.dto.LectureImgFileDto;
import com.jaego.web.dto.MemberDto;
import com.jaego.web.dto.MentorDto;
import com.jaego.web.service.LectureServiceImpl;
import com.jaego.web.service.MentorServiceImpl;
import com.jaego.web.service.OrderServiceImpl;


@Controller
public class LectureController {
	
	
	
	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest,String path) {
		List<String> fileList = new ArrayList<String>();
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while(fileNames.hasNext()) {
			String fileName=fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			String originalFileName = mFile.getOriginalFilename();
			fileList.add(originalFileName);
			if(mFile.getSize()!=0) {
				try {
					mFile.transferTo(new File(path+"/"+originalFileName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return fileList;
	}

	
	
	
	@Autowired
	LectureServiceImpl lectureService;
	
	@Autowired
	MentorServiceImpl mentorService;

	@Autowired
	OrderServiceImpl orderService;
	
	public void setLectureService(LectureServiceImpl lectureService) {
		this.lectureService = lectureService;
	}
	
	@RequestMapping(value="/LectureAdd",method=RequestMethod.GET)
	public String addLecture(Model model,HttpSession session) {
	MemberDto myMember =(MemberDto)session.getAttribute("memberLogin");
	MentorDto myMentor = mentorService.selectByMemberId(myMember.getMemberId());
	model.addAttribute("myMentorId",myMentor.getMentorId());
		return "/mentor/LectureAdd";
	}
	
	@RequestMapping(value="/LectureAdd",method=RequestMethod.POST)
	public String addLecture(MultipartHttpServletRequest multipartRequest,HttpServletRequest req) throws IOException   {
		 String path = req.getServletContext().getRealPath("/")+"/resources//lectureImg";
		
		//저장할 폴더가 없는 경우 생성
	    File filePathDir = new File(path);
	    if(!filePathDir.exists()) {
	    	filePathDir.mkdir();
	    }
	 
		 System.out.println(path);
		multipartRequest.setCharacterEncoding("utf-8");
		
		Map<String,Object> lectureMap = new HashMap<String,Object>();
		System.out.println(multipartRequest.getParameter("lectureStart").getClass().getName());
		Enumeration enu = multipartRequest.getParameterNames();  
		while(enu.hasMoreElements()) {
			String name = (String)enu.nextElement();
			String value = multipartRequest.getParameter(name);
			lectureMap.put(name, value);
		}
		
		int lectureId=	lectureService.insertLecture(lectureMap);

		
		
		List<String> fileList = fileProcess(multipartRequest,path);
		List<LectureImgFileDto> imgFileList = new ArrayList<LectureImgFileDto>();
		
		if(fileList !=null && fileList.size()!=0) {
			for(String fileName : fileList) {
				LectureImgFileDto fileDto = new LectureImgFileDto();
				fileDto.setLectureImg(fileName);
				fileDto.setLectureId(lectureId);
				imgFileList.add(fileDto);
			}
			lectureService.insertLectureImgFile(imgFileList);
		}
			
	
		
		return "redirect:/MyMentorLecture";
	}
	
	
	@RequestMapping(value="/view/{lectureId}",method=RequestMethod.GET)
	public String view(Model model,@PathVariable int lectureId) {
		Map<String,Object> viewInfo = lectureService.view(lectureId);
		List<MemberDto> members = orderService.orderMember(lectureId);

		model.addAttribute("members",members);
		model.addAttribute("memberSize",members.size());
		model.addAttribute("viewInfo",viewInfo);
		
		return "/vod/view";
	}
	
	
	
	
	
	
	

}
