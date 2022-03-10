package com.jaego.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jaego.web.dto.MemberDto;
import com.jaego.web.service.MemberService;

@Controller
public class RegisterController {
	
	@Autowired
	private MemberService memberService;
	
	
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Model model,HttpSession session) {
		
		model.addAttribute("memberDto", new MemberDto());
		
		return "/member/registerForm";
	}
	
	@RequestMapping(value="/check.do" ,method = RequestMethod.POST)
	public ResponseEntity check(@RequestParam("email1") String email1,@RequestParam("email2") String email2,HttpServletRequest req, HttpServletResponse resp) throws Exception{
		ResponseEntity resEntity = null;
		String result =null;
		if(memberService.checkEmail(email1,email2)==0) {
			result = "false";
		}else {
			result = "true";
		}
		resEntity =new ResponseEntity(result, HttpStatus.OK);
		return resEntity;
	}
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@ModelAttribute("memberDto") @Valid MemberDto memberDto,
							BindingResult bindingResult, Errors errors,HttpSession session,Model model) {
		String email1 = memberDto.getMemberEmail1();
		String email2 = memberDto.getMemberEmail2();
		
		if(bindingResult.hasErrors()) {
			System.out.println("바인딩 에러 발생");
			System.out.println("바인딩 에러 수 : " + bindingResult.getErrorCount());
			List<ObjectError> list = bindingResult.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("바인딩 에러 : " + error);
			}
			return "/member/registerForm";
		}
		if(memberService.checkEmail(email1,email2) !=0) {
//			String errorMsg1 = "존재하는 회원 이메일입니다.";
//			model.addAttribute("msg1", errorMsg1);
			return "/member/registerForm";
		}else if (!memberDto.getMemberPassword().equals(memberDto.getConfirmPassword())) {
			String errorMsg = "비밀번호와 확인이 다릅니다.";
			model.addAttribute("msg", errorMsg);
			return "/member/registerForm";
		}else {
			memberService.insert(memberDto);		
		}
		return "redirect:/login";
	}

}
