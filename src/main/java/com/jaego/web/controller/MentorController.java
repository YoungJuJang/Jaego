package com.jaego.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jaego.web.dto.MentorDto;
import com.jaego.web.service.MentorService;
import com.jaego.web.service.MentorServiceImpl;

@Controller
public class MentorController {
	@Autowired
	private MentorServiceImpl mentorService;
//	@Autowired
//	private MentorDto mentorDto;
	
	
	
// 멘토 등록	
	
	@RequestMapping(value="/MentorAdd" ,method=RequestMethod.GET)
	public String list(Model model) {
		
		model.addAttribute("mentor",new MentorDto());
		return "/mentor/MentorAdd";
	}
	
	@RequestMapping(value="/MentorAdd", method=RequestMethod.POST)
	public String list(@ModelAttribute("mentor") @Valid MentorDto mentor,BindingResult bindingResult, Errors errors,
			@RequestParam(name = "file")MultipartFile image,HttpServletRequest req ) throws Exception {
		String path = "/resources//mentorImg";
	    String filePath = req.getSession().getServletContext().getRealPath("/")+path;  
		String fileName = image.getOriginalFilename();
		
		//저장할 폴더가 없는 경우 생성
	    File filePathDir = new File(filePath);
	    if(!filePathDir.exists()) {
	    	filePathDir.mkdir();
	    }
		System.out.println(filePath);
		System.out.println(fileName);
		
		
		if(bindingResult.hasErrors()) {
			System.out.println("바인딩 에러 발생");
			System.out.println("바인딩 에러 수 : " + bindingResult.getErrorCount());
			List<ObjectError> list = bindingResult.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("바인딩 에러 : " + error);
			}
			return "/mentor/MentorAdd";
		}
		if(!fileName.isEmpty()) {
				File p =  new File(filePath+"/"+fileName);
				image.transferTo(p);
				mentor.setMentorImg(fileName);
				mentorService.add(mentor);
				return "redirect:/MyMentorLecture";
		} else {
			errors.reject("fuckingImg");
			return "/mentor/MentorAdd";
		}
		

	}

// 멘토 정보 수정 
	
	@RequestMapping(value="/mentor/mentorEdit", method=RequestMethod.GET)
	public String update(HttpSession session, Model model) throws Exception{
		model.addAttribute("mentorDto", new MentorDto());
		return "mentor/mentorEdit";
	}
	
		
// 멘토 정보 삭제
	@RequestMapping(value="/mentor/mentorDel", method=RequestMethod.GET)
	public String delete(HttpSession session, Model model) throws Exception{
		model.addAttribute("mentorDto", new MentorDto());
		
		return "/mentor/mentorDel";
	}
	
	@RequestMapping(value="/mentor/mentorDel", method=RequestMethod.POST)
	public String delete(MentorDto dto) {
		
		mentorService.delete(dto);
		
		return "redirect:/main";
		
	}
}