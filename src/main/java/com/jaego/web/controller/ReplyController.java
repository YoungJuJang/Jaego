package com.jaego.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jaego.web.dto.ReplyDto;
import com.jaego.web.service.ReplyService;
import com.jaego.web.util.PageMaker;

@Controller
@RequestMapping(value = "/reply/**")
public class ReplyController {

	@Autowired
	ReplyService replyService;

	// 댓글 입력
	@RequestMapping("insert")
	@ResponseBody
	public int insert(@ModelAttribute("reply") ReplyDto replyDto, HttpSession session) {
		try {
			replyService.create(replyDto);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
	}

	// 댓글 목록
	@RequestMapping("list")
	public String list(@RequestParam int lectureroomId, PageMaker pageMaker, Model model, HttpServletRequest request,
			Map<String, Object> param) {
		int totCount = replyService.replyTotalCount(lectureroomId);
		pageMaker.setTotPage(totCount);
		param.put("lectureroomId", lectureroomId);
		param.put("pageMaker", pageMaker);

		String pagination= pageMaker.bootStrapPagingHTML(request.getContextPath()  +"/lectureroom/read/"+lectureroomId);
		
		List<ReplyDto> list = replyService.list(param);
		model.addAttribute("list", list);
		model.addAttribute("pagination", pagination);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("totCount", totCount);
		return "lectureroom/replyList";
	}

	// 댓글 입력
	@RequestMapping("listJson")
	@ResponseBody // 리턴 데이터를 json으로 변환(생략가능)
	public ResponseEntity<?> listJson(@RequestParam int lectureroomId, PageMaker pageMaker, Model model,
			HttpServletRequest request, Map<String, Object> param) {

		
		int totCount = replyService.replyTotalCount(lectureroomId);
		pageMaker.setTotPage(totCount);
		param.put("lectureroomId", lectureroomId);
		param.put("pageMaker", pageMaker);
		String pagination= pageMaker.bootStrapPagingHTML(request.getContextPath()  +"/lectureroom/read/"+lectureroomId);
		
		Map<String, Object> resultMap=new HashMap<>();
		
		List<ReplyDto> list = replyService.list(param);
		resultMap.put("pagination", pagination);
		resultMap.put("totCount", totCount);
		resultMap.put("list", list);
		
		return new ResponseEntity<>(resultMap, HttpStatus.OK);
	}
	
	

}
