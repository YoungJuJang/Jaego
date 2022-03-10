package com.jaego.web.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jaego.web.dto.LectureReviewDto;
import com.jaego.web.dto.LectureroomDto;
import com.jaego.web.dto.MemberDto;
import com.jaego.web.service.LectureReviewService;
import com.jaego.web.util.PageMakers;

@Controller
@SessionAttributes("lecturereviewDto")
public class LectureReviewController {
	
	@Autowired
	private LectureReviewService lectureReviewService;
	
	
	@RequestMapping(value="/review/list")
	public String list( PageMakers  pageMakers , Model model , HttpServletRequest request ){
		int totCount=lectureReviewService.reviewTotalCount(pageMakers);
		pageMakers.setTotPage(totCount);
		List<LectureReviewDto>  reviewList=lectureReviewService.reviewList(pageMakers);
		String pagination= pageMakers.bootStrapPagingHTML(request.getContextPath()  +"/review/list");
		
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageMakers", pageMakers);
		model.addAttribute("totCount", totCount);
		model.addAttribute("reviewList",reviewList);
		return "/review/list";
	}
	
	@RequestMapping(value="/review/read/{reviewId}")
	public String read(Model model, @PathVariable int reviewId) {
		model.addAttribute("lecturereviewDto", lectureReviewService.read(reviewId));
		return "/review/read";
		
	}
	
	//리뷰 작성
	@RequestMapping(value="/review/write",method=RequestMethod.GET)
	public String write(Model model, LectureReviewDto  lecturereviewDto ,HttpSession session) {
		
		MemberDto myMember = (MemberDto)session.getAttribute("memberLogin");
		int myMemberId = myMember.getMemberId();
		
		String title = lectureReviewService.selectTitle(lecturereviewDto.getLectureId());
		System.out.println(title);
		lecturereviewDto.setTitle(title);
		model.addAttribute("lecturereviewDto",lecturereviewDto);
		return "/review/write";
	}
	
	//리뷰 등록
	@RequestMapping(value="/review/write",method=RequestMethod.POST)
	public String write(@ModelAttribute("LectureReviewDto")LectureReviewDto LectureReviewDto) {
		
		lectureReviewService.insert(LectureReviewDto);
		return "redirect:/review/list?lectureId="+LectureReviewDto.getLectureId();
	}
	
	//리뷰 삭제
	@RequestMapping(value="/review/delete/{reviewId}",method=RequestMethod.GET)
	public String delete (@PathVariable("reviewId")int reviewId , String lectureId) throws Exception{
		lectureReviewService.delete(reviewId);
		return "redirect:/review/list?lectureId="+lectureId;
	}
	
	
	//리뷰 수정
	@RequestMapping(value="/review/edit/{reviewId}",method=RequestMethod.GET)
	public String update(@PathVariable("reviewId")int reviewId,Model model) throws Exception{
		LectureReviewDto lecturereviewDto = lectureReviewService.read(reviewId);
		model.addAttribute("lecturereviewDto",lecturereviewDto);
		return "/review/edit";
	}
	

	
	@RequestMapping(value="/review/edit/{reviewId}",method=RequestMethod.POST)
	public String update(LectureReviewDto lecturereviewDto) throws Exception{
		lectureReviewService.update(lecturereviewDto);
		return "redirect:/review/list?lectureId="+lecturereviewDto.getLectureId();
	};
	
	
	
}
