package com.jaego.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaego.web.dto.FindDto;
import com.jaego.web.service.MemberServiceImpl;

@Controller
public class FindController {

	@Autowired
	private MemberServiceImpl memberService;
	
	@Autowired
	private FindDto findDto;
	
	public void setMemberService(MemberServiceImpl memberService) {
		this.memberService = memberService;
	}
	

	@RequestMapping(value = "/findPage", method = RequestMethod.GET)
	public String findPage(Model model, HttpSession session) {

		return "/member/memberFind";
	}

	@RequestMapping(value = "/findEmail", method = RequestMethod.POST)
	@ResponseBody
	public String findEmail(@ModelAttribute("findDto") @Valid FindDto findDto,
			BindingResult bindingResult, Errors errors, Model model) {

		FindDto resultMem = memberService.findEmail(findDto);
		
		String result = null;

		if (resultMem != null) {
			if (resultMem.getMemberEmail() != null) {
				result = resultMem.getMemberEmail();
			}
		}else {
			result = "fail";
		}

		System.out.println("웅: " + result);
		return result;
	}

	
	
	@RequestMapping(value = "/findPassword", method = RequestMethod.POST)
	public String findPassword(@ModelAttribute("findDto") @Valid FindDto findDto,
			BindingResult bindingResult, Model model) {

		memberService.findPassword(findDto);
		
		return "member/memberFind"; 


	}

}
