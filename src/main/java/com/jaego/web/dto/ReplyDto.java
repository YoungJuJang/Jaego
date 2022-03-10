package com.jaego.web.dto;

import java.sql.Date;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component("replyDto")
@Alias("replyDto")
public class ReplyDto {

	private int replyId;
    private int lectureroomId; 
    private String replyer; 
    private String replyContent;    
    private Timestamp replyRegdate;
    
    
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public int getLectureroomId() {
		return lectureroomId;
	}
	public void setLectureroomId(int lectureroomId) {
		this.lectureroomId = lectureroomId;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Timestamp getReplyRegdate() {
		return replyRegdate;
	}
	public void setReplyRegdate(Timestamp replyRegdate) {
		this.replyRegdate = replyRegdate;
	}       
    
	
    
	
    
}
