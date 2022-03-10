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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.jaego.web.dto.LectureroomDto;
import com.jaego.web.dto.MemberDto;
import com.jaego.web.service.LectureroomServiceImpl;
import com.jaego.web.service.MemberService;
import com.jaego.web.util.PageMaker;

@Controller
@SessionAttributes("lectureroomDto")
public class LectureroomController {
	

	@Autowired
	private LectureroomServiceImpl lectureroomService;
	
	@Autowired
	private MemberService memberService;
	
	public void setLectureroomService(LectureroomServiceImpl lectureroomService) {
		this.lectureroomService = lectureroomService;
	}
	
	
	@RequestMapping(value="/lectureroom/list")
	public String list(@ModelAttribute("LectureroomDto") LectureroomDto lectureroom,
					PageMaker pageMaker, Model model, HttpServletRequest request, HttpSession session){
		
		MemberDto myMember = (MemberDto)session.getAttribute("memberLogin");
		String memberName = myMember.getMemberName();
		System.out.println("로그인 세션의 회원 이름 : " + memberName);
		
		int totCount=lectureroomService.lectureroomTotalCount(pageMaker);
		pageMaker.setTotPage(totCount);
		List<LectureroomDto>  lectureroomList=lectureroomService.lectureroomList(pageMaker);
		String pagination= pageMaker.bootStrapPagingHTML(request.getContextPath()  +"/lectureroom/list");
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("totCount", totCount);		
		model.addAttribute("lectureroomList", lectureroomList);
		return "/lectureroom/list";
	}
	
	
	//새글 작성
	@RequestMapping(value="/lectureroom/write", method=RequestMethod.GET)
	public String write(Model model, HttpSession session) {
		model.addAttribute("lectureroomDto", new LectureroomDto());
		MemberDto myMember = (MemberDto)session.getAttribute("memberLogin");
		MemberDto myProfile = memberService.myProfile(myMember.getMemberId());
		
		model.addAttribute("myProfile", myProfile);
		
		return "/lectureroom/write";
	}
	
	//새글 등록
	@RequestMapping(value="/lectureroom/write", method=RequestMethod.POST)
	public String write(@ModelAttribute("lectureroomDto")LectureroomDto lectureroom,
			@RequestParam(name="file")MultipartFile image, HttpServletRequest req,
			@Valid LectureroomDto lectureroomDto,
			BindingResult bindingResult) throws Exception 
	{
		String path = "/resources/lectureroom";
		String filePath = req.getSession().getServletContext().getRealPath("/")+path;
		String fileName = image.getOriginalFilename();
		
		//저장할 폴더가 없는 경우 생성
	    File filePathDir = new File(filePath);
	    if(!filePathDir.exists()) {
	    	filePathDir.mkdir();
	    }
		
		
		if(bindingResult.hasErrors()) {
			return "/lectureroom/write";
		}
		if(!fileName.isEmpty()) {
			try {
				File p = new File(filePath+"/"+fileName);
				image.transferTo(p);
				lectureroom.setLectureroomFname(fileName);
				lectureroomService.write(lectureroom);
			}catch(RuntimeException e) {
				return "/lectureroom/write";
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			lectureroomService.write(lectureroomDto);
			return "redirect:/lectureroom/list?lectureId="+lectureroom.getLectureId();
		}
		return "redirect:/lectureroom/list?lectureId="+lectureroom.getLectureId();
	}
	
	// 글 읽기
	@RequestMapping(value="/lectureroom/read/{lectureroomId}")
	public String read(Model model, @PathVariable int lectureroomId, HttpSession session) {
		
		System.out.println(lectureroomService.select(lectureroomId));
		LectureroomDto myLectureroom = lectureroomService.select(lectureroomId);
		System.out.println("read의 렉쳐아이디 : " + myLectureroom.getLectureId());
		System.out.println("read의 렉쳐룸아이디 : " + myLectureroom.getLectureroomId());
		
		model.addAttribute("myLectureroom", myLectureroom);
		return "/lectureroom/read";
		
	}
	
	
	
	
	//글 수정
	@RequestMapping(value="/lectureroom/edit/{lectureroomId}", method=RequestMethod.GET)
	public String edit(@PathVariable int lectureroomId, Model model) {
			LectureroomDto lectureroomDto = lectureroomService.select(lectureroomId);
			model.addAttribute("lectureroomDto", lectureroomDto);
			return "/lectureroom/edit";
	}
	
	@RequestMapping(value="/lectureroom/edit/{lectureroomId}", method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute LectureroomDto lectureroomDto,
			BindingResult result, @RequestParam("pwd") String pwd,
			SessionStatus sessionStatus, Model model) {
		
		if(result.hasErrors()) {
			return "/lectureroom/edit";
		
		}else if (lectureroomDto.getLectureroomPassword().equals(pwd)) {
			System.out.println("dto 비번" + lectureroomDto.getLectureroomPassword());
			System.out.println(pwd);
			System.out.println(lectureroomDto.getLectureroomPassword().equals(pwd));
			lectureroomService.edit(lectureroomDto);
			sessionStatus.setComplete();
			return "redirect:/lectureroom/list?lectureId="+lectureroomDto.getLectureId();
			
		}else {
			System.out.println(lectureroomDto.getLectureroomPassword().equals(pwd));
			String msg = "비밀번호가 일치하지 않습니다.";
			model.addAttribute("msg",msg);
			return  "/lectureroom/edit";
		
		}
	}
	
	
	
	@RequestMapping(value="/lectureroom/delete/{lectureroomId}", method=RequestMethod.GET)
	public String delete(@PathVariable int lectureroomId, Model model) {
		System.out.println("delete get의 lectureroomId : " + lectureroomId);
		
		LectureroomDto lectureroomDto = lectureroomService.select(lectureroomId);
		model.addAttribute("lectureroomDto", lectureroomDto);
		model.addAttribute("lectureroomId", lectureroomId);
		return "/lectureroom/delete";
	}
	
	@RequestMapping(value="/lectureroom/delete/{lectureroomId}", method=RequestMethod.POST)
	public String delete(
						@PathVariable int lectureroomId, LectureroomDto lectureroomDto,
						@RequestParam("pwd") String pwd, Model model) {

		lectureroomDto.setLectureroomId(lectureroomId);
		
		if(lectureroomDto.getLectureroomPassword().equals(pwd)) {
			System.out.println(lectureroomDto.getLectureroomPassword().equals(pwd));
			
			lectureroomService.delete(lectureroomId);
			return "redirect:/lectureroom/list?lectureId="+lectureroomDto.getLectureId();
		}
		else {
			System.out.println(lectureroomDto.getLectureroomPassword().equals(pwd));
			
			String msg = "비밀번호가 일치하지 않습니다.";
			model.addAttribute("msg", msg);
			return  "/lectureroom/delete";
		}
	}
	
	// 댓글
	@RequestMapping(value="/lectureroom/reply/{lectureroomId}", method=RequestMethod.GET)
	public String reply(Model model,@PathVariable int lectureroomId) {
		model.addAttribute("lectureroomDto", new LectureroomDto());
		model.addAttribute("lectureroomId", lectureroomId);
		return "/lectureroom/reply";
	}
	
	@RequestMapping(value="/lectureroom/reply/{lectureroomId}", method=RequestMethod.POST)
	public String reply(LectureroomDto lectureroomDto, BindingResult bindingResult) {
		System.out.println(lectureroomDto.getLectureroomId());
		if(bindingResult.hasErrors()) {
			return "/lectureroom/reply";
		}
		lectureroomService.reply(lectureroomDto);
		return "redirect:/lectureroom/read/{lectueroomId}";
	}
	
}