package com.jaego.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jaego.web.dto.LectureDto;
import com.jaego.web.dto.LectureImgFileDto;
import com.jaego.web.service.LectureServiceImpl;

import net.sf.json.JSONObject;


@Controller
public class MainController {
	
	@Autowired
	LectureServiceImpl lectureService;
	
	
	@RequestMapping(value={"/", "/main"},method=RequestMethod.GET)
	public String main(Model model,HttpSession session,HttpServletRequest req) {
		String page =req.getParameter("page"); // 현재 페이지를 파라미터로 가져옴
		
		//paging
		int lectureCount = lectureService.lectureCount(); //강의 전체 갯수
		int pageSize = 9; //한 페이지 당 보여줄 갯수
		int pages; //페이지 갯수
		if(page==null) { 
			page ="1";
		}
		if(lectureCount%pageSize==0) {
			pages = lectureCount/pageSize;
		}else {
			pages = lectureCount/pageSize +1;
		}
		
		int start = (Integer.parseInt(page)-1) * pageSize; //만약 1페이지면 0*10 이니까 start는 0 
		
		List<LectureDto> lectures = lectureService.selectAll(start, pageSize);
		List<LectureImgFileDto> lecturesImg = new ArrayList<LectureImgFileDto>();
		
		for(int i=0; i<lectures.size();i++) {
			lecturesImg.add(lectureService.myOrderLectureImg(lectures.get(i).getLectureId()));
		}
		
		
		
		model.addAttribute("pages", pages);
		model.addAttribute("lectures", lectures);
		model.addAttribute("lecturesImg", lecturesImg);

		return "/main";
	}
	
	@RequestMapping(value="/keywordSearch.do",method=RequestMethod.GET,produces="application/text;charset=utf8")
	public @ResponseBody String keywordSearch(@RequestParam("keyword") String keyword,HttpServletRequest req,HttpServletResponse resp) {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		if(keyword==null || keyword.equals("")) return null;
		
		keyword=keyword.toUpperCase();
		List keywordList = lectureService.lectureTitle(keyword);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyword", keywordList);
		String jsonInfo = jsonObject.toString();
		return jsonInfo;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView category(Model model,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String category = req.getParameter("category");
		String search;
		System.out.println(category);
		switch(category) {
		case "1":
			search = "외국어";
			break;
		case "2":
			search = "커리어";
			break;
		case "3":
			search = "디자인/영상";
			break;
		case "4":
			search = "뷰티/헬스";
			break;
		default :
			search = "라이프";
			break;
		}
		List<LectureDto> lectures = lectureService.categoryLecture(search);
		List<LectureImgFileDto> lecturesImg = new ArrayList<LectureImgFileDto>();
		for(int i=0; i<lectures.size();i++) {
			lecturesImg.add(lectureService.myOrderLectureImg(lectures.get(i).getLectureId()));
		}
		model.addAttribute("lectures",lectures);
		model.addAttribute("lecturesImg",lecturesImg);

		mv.addObject("lectures");
		mv.addObject("lecturesImg");
		mv.setViewName("/main");
		
		return mv;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView search(Model model,HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String search = req.getParameter("search");
		List<LectureDto> lectures = lectureService.searchLecture(search);
		List<LectureImgFileDto> lecturesImg = new ArrayList<LectureImgFileDto>();
		
		for(int i=0; i<lectures.size();i++) {
			lecturesImg.add(lectureService.myOrderLectureImg(lectures.get(i).getLectureId()));
		}
		
		model.addAttribute("lectures",lectures);
		model.addAttribute("lecturesImg",lecturesImg);

		mv.addObject("lectures");
		mv.addObject("lecturesImg");
		mv.setViewName("/main");
		
		
		
		return mv;
	}
	
	@RequestMapping(value="/fail",method=RequestMethod.GET)
	public ModelAndView fail() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/fail");
		return mv;
	}
	
	
	
	
	

}
