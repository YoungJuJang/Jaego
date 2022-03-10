package com.jaego.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;


@Component
public class DownloadView extends AbstractView{
	public DownloadView() {
		setContentType("application/download; charset=utf-8");
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		File file = (File)model.get("downloadFile");
		
		String orignalName = (String)model.get("orignalName");

		response.setContentType(getContentType());

		response.setContentLength((int)file.length());
		
		String fileName = null;
		
		if (orignalName != null && orignalName.trim().length() > 0) {
			fileName = orignalName;
		} else {
			fileName = file.getName();
		}
		
		fileName = URLEncoder.encode(fileName, "utf-8");
		
		fileName = fileName.replaceAll("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();

		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);

			FileCopyUtils.copy(fis, out);

		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}

		}
		out.flush();
	}
}
