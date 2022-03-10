package com.jaego.web.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaego.web.dto.LectureDto;
import com.jaego.web.dto.LectureImgFileDto;
import com.jaego.web.dto.MemberDto;
import com.jaego.web.dto.MentorDto;
import com.jaego.web.service.LectureService;
import com.jaego.web.service.MemberService;
import com.jaego.web.service.MentorService;
import com.jaego.web.service.OrderService;

@Controller
public class ProfileController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	LectureService lectureService;
	
	@Autowired
	MentorService mentorService;
	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping(value="/MyMentorLecture",method = RequestMethod.GET)
	public String selectMentorLecture(HttpSession session,Model model) {
		MemberDto myMember = (MemberDto)session.getAttribute("memberLogin");
		MentorDto myMentor = mentorService.selectByMemberId(myMember.getMemberId());
		
		if(myMentor==null) {
			return "/myProfile/RegisterMentor";
		}
		
		int mId = myMentor.getMentorId();
		Map<String,Object> myLectureInfo = lectureService.selectMyLecture(mId);
		try {
		LectureDto myLecture = (LectureDto)myLectureInfo.get("myLecture");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일");
		String start = sf.format(myLecture.getLectureStart());
		String end = sf.format(myLecture.getLectureEnd());
		List<LectureImgFileDto> myLectureImg = (List<LectureImgFileDto>)myLectureInfo.get("myLectureImg");
		model.addAttribute("myMentor",myMentor);
		model.addAttribute("myLecture",myLecture);
		model.addAttribute("start",start);
		model.addAttribute("end",end);
		model.addAttribute("myLectureImg",myLectureImg);
		}catch(NullPointerException e) {
			model.addAttribute("myMentor",myMentor);
		}
		return "/myProfile/MyMentorLecture";
	}
	
	@RequestMapping(value="/MyProfile",method = RequestMethod.GET)
	public String myProfile(HttpSession session,Model model) {
		List<LectureDto> myOrderLecture;
		List<LectureImgFileDto> myOrderLectureImg = new ArrayList<LectureImgFileDto>();
		MemberDto myMember = (MemberDto)session.getAttribute("memberLogin");
		MemberDto myProfile = memberService.myProfile(myMember.getMemberId());
		
		myOrderLecture = lectureService.myOrderLecture(myMember.getMemberId());

		
		for(int i=0; i<myOrderLecture.size();i++) {
			LectureImgFileDto LectureImg=lectureService.myOrderLectureImg(myOrderLecture.get(i).getLectureId());
			myOrderLectureImg.add(LectureImg);
		}
		
		
		
		model.addAttribute("myProfile",myProfile);
		model.addAttribute("myOrderLecture",myOrderLecture);
		model.addAttribute("myOrderLectureImg",myOrderLectureImg);
		
		

		return"/myProfile/myProfile";
	}
	
	
	@RequestMapping(value="/ProfileEdit",method = RequestMethod.GET)
	public String profileEdit(HttpSession session, Model model) {
		
		List<LectureDto> myOrderLecture;
		List<LectureImgFileDto> myOrderLectureImg = new ArrayList<LectureImgFileDto>();
		MemberDto myMember = (MemberDto)session.getAttribute("memberLogin");
		MemberDto myProfile = memberService.myProfile(myMember.getMemberId());
		
		myOrderLecture = lectureService.myOrderLecture(myMember.getMemberId());

		
		for(int i=0; i<myOrderLecture.size();i++) {
			LectureImgFileDto LectureImg=lectureService.myOrderLectureImg(myOrderLecture.get(i).getLectureId());
			myOrderLectureImg.add(LectureImg);
		}
		
		model.addAttribute("myProfile",myProfile);
		model.addAttribute("myOrderLecture",myOrderLecture);
		model.addAttribute("myOrderLectureImg",myOrderLectureImg);
		
		

		return "/myProfile/profileEdit";
	}
	
	@RequestMapping(value="/ProfileEdit",method = RequestMethod.POST)
	public String profileEdit(HttpSession session,Model model, MemberDto memberDto) {
		
		memberService.update(memberDto);
		
		return "/myProfile/myProfile";
	}
	

	
	
	
	
	
	

}
