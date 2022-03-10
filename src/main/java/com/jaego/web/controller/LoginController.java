package com.jaego.web.controller;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jaego.web.dto.LoginDto;
import com.jaego.web.dto.MemberDto;
import com.jaego.web.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private LoginDto loginDto;
	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginMain(Model model,HttpSession session) {
		
		model.addAttribute("loginDto", new LoginDto());
		
		Object checkLogin = session.getAttribute("memberLogin");
		if(checkLogin!=null) {
			return "redirect:/main";
		}
		
		return "/member/loginForm";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
				@ModelAttribute("loginDto") @Valid LoginDto loginDto,
				BindingResult bindingResult, Model model, HttpSession session) {
	
		if(bindingResult.hasErrors()) {	
			return "/member/loginForm";
		}
		
		MemberDto login = memberService.login(loginDto);
		
		if(login != null) {	// 로그인 성공
			session.setAttribute("memberLogin", login);
			return "redirect:/main";	
		
		}else{	// 아이디 또는 비번 불일치
			model.addAttribute("msg2", "이메일 또는 비밀번호가 일치하지 않습니다.");
			return "/member/loginForm";
		}
		
	}
	
	
	// 로그아웃
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/main";
	}

	
	
	

}
