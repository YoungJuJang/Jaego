package com.jaego.web.dto;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;

@Alias(value="mentorDto")
public class MentorDto {
   private int mentorId;
   private int memberId;
   //@NotEmpty(message ="자신의 사진을 올려주세요.")
   private String mentorImg;
   @NotEmpty(message="멘토 자신을 소개해주세요.")
   private String mentorContent;
   @NotEmpty(message ="자신의 경력을 1개 이상 적어주세요.")
   private String mentorCareer1;
   private String mentorCareer2;
   private String mentorCareer3;
   private String mentorCareer4;
   private String mentorCareer5;
   @NotEmpty(message="자신을 소개할 sns혹은 블로그, GIT등 링크를 공유해주세요.")
   private String mentorLink1;
   private String mentorLink2;
   private String mentorLink3;
   
   @NotEmpty(message="본인의 계좌번호를 작성해주세요.")
   private String mentorAccount;
   @NotEmpty(message="은행을 선택해주세요.")
   private String mentorBank;
   private int mentorStatus;

	

	
	
	public MentorDto() {
		super();
	}

	public int getMentorId() {
		return mentorId;
	}
	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMentorImg() {
		return mentorImg;
	}
	public void setMentorImg(String mentorImg) {
		this.mentorImg = mentorImg;
	}
	public String getMentorContent() {
		return mentorContent;
	}
	public void setMentorContent(String mentorContent) {
		this.mentorContent = mentorContent;
	}
	public String getMentorCareer1() {
		return mentorCareer1;
	}
	public void setMentorCareer1(String mentorCareer1) {
		this.mentorCareer1 = mentorCareer1;
	}
	public String getMentorCareer2() {
		return mentorCareer2;
	}
	public void setMentorCareer2(String mentorCareer2) {
		this.mentorCareer2 = mentorCareer2;
	}
	public String getMentorCareer3() {
		return mentorCareer3;
	}
	public void setMentorCareer3(String mentorCareer3) {
		this.mentorCareer3 = mentorCareer3;
	}
	public String getMentorCareer4() {
		return mentorCareer4;
	}
	public void setMentorCareer4(String mentorCareer4) {
		this.mentorCareer4 = mentorCareer4;
	}
	public String getMentorCareer5() {
		return mentorCareer5;
	}
	public void setMentorCareer5(String mentorCareer5) {
		this.mentorCareer5 = mentorCareer5;
	}
	public String getMentorLink1() {
		return mentorLink1;
	}
	public void setMentorLink1(String mentorLink1) {
		this.mentorLink1 = mentorLink1;
	}
	public String getMentorLink2() {
		return mentorLink2;
	}
	public void setMentorLink2(String mentorLink2) {
		this.mentorLink2 = mentorLink2;
	}
	public String getMentorLink3() {
		return mentorLink3;
	}
	public void setMentorLink3(String mentorLink3) {
		this.mentorLink3 = mentorLink3;
	}
	public String getMentorAccount() {
		return mentorAccount;
	}
	public void setMentorAccount(String mentorAccount) {
		this.mentorAccount = mentorAccount;
	}
	public String getMentorBank() {
		return mentorBank;
	}
	public void setMentorBank(String mentorBank) {
		this.mentorBank = mentorBank;
	}
	public int getMentorStatus() {
		return mentorStatus;
	}
	public void setMentorStatus(int mentorStatus) {
		this.mentorStatus = mentorStatus;
	}
		
}
