package com.jaego.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jaego.web.dto.MemberDto;
import com.jaego.web.service.LectureService;
import com.jaego.web.service.MemberService;
import com.jaego.web.service.MentorService;

public class notDuplicateInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MentorService mentorService;
	
	@Autowired
	LectureService lectureService;

	@Override
	public boolean preHandle(HttpServletRequest req,HttpServletResponse resp,Object handler) throws Exception{
		HttpSession session =req.getSession(false);
		if(session!=null) {
			MemberDto Login = (MemberDto) session.getAttribute("memberLogin");
			int memberId = Login.getMemberId();
			if(mentorService.selectByMemberId(memberId) != null) {
				System.out.print(mentorService.selectByMemberId(memberId));
				resp.sendRedirect(req.getContextPath()+"/fail");
				return false;
			}else if(lectureService.selectMyLecture(memberId) != null) {
				resp.sendRedirect(req.getContextPath()+"/fail");
				return false;
			}else {
				return true;
			}
			
			
			
		}
		resp.sendRedirect(req.getContextPath()+"/login");
		return false;
	}

	
	
}
