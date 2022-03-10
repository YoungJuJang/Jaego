package com.jaego.web.util;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class DownloadController {


	private String RES_PATH="/resources/lectureroom";
	

	private String ROOT_PATH ="/";
	
	

	
	@Autowired
	private WebApplicationContext context;
	
	
	private static final Logger logger = LoggerFactory.getLogger(DownloadController.class);
	
	/**
	 * file 폴더 하위 탬플릿 파일 다운로드
	 * @param fileName
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/downloadTmpl")
	public String downloadFile(@RequestParam("file_name") String fileName, Model model) throws Exception {
		File file = new File(context.getServletContext().getRealPath("resources/file/" + fileName));
		model.addAttribute("downloadFile", file);
		return "downloadView";
	}

	@RequestMapping(value = "/file/download", method = RequestMethod.GET)
	public String fileDownload(@RequestParam("file_name") String fileName
			, @RequestParam("file_path") String filePath , Model model, HttpServletRequest request) throws Exception {
		
		String fileUploadPath = "resources"+File.separator+"lectureroom"+File.separator;
		ROOT_PATH = request.getSession().getServletContext().getRealPath("/")+fileUploadPath;
	
		
		if (filePath != null && !filePath.equals("")) {
			String path = ROOT_PATH + filePath;
	/*		if (fileName == null || fileName.equals("")) {
				path = ROOT_PATH + filePath;
			}*/
			
			File file = new File(path);
			model.addAttribute("downloadFile", file);
			model.addAttribute("orignalName", fileName);
		}
		
		
		return "downloadView";

	}
	
	
	@RequestMapping(value = "/displayFile2", method = RequestMethod.GET)
	public DownloadView fileDownload(@RequestParam("fileName") String fileName, @RequestParam("orignalName") String orignalName
			, HttpServletRequest request, Model model) throws Exception {
			   
	   // String path=ROOT_PATH + RES_PATH;
	   
		String fileUploadPath = "resources"+File.separator+"lectureroom"+File.separator;
		ROOT_PATH = request.getSession().getServletContext().getRealPath("/")+fileUploadPath;
	    
		File file = new File(ROOT_PATH+fileName);
		model.addAttribute("downloadFile", file);
		model.addAttribute("orignalName", orignalName);
		logger.info("orignalName : 원본 이름 " +orignalName, "UTF-8");	
		
		
		DownloadView downloadView=new DownloadView();
		
		return downloadView;
	}
	
	
		
}