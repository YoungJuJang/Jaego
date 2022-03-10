package com.jaego.web.dto;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component("loginDto")
@Alias("loginDto")
public class LoginDto {
	
	@NotEmpty(message="이메일을 입력하세요")
	private String memberEmail;
	
	@NotEmpty(message="비밀번호를 입력하세요")
	private String memberPassword;
	
	public LoginDto() {
		
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	@Override
	public String toString() {
		return "LoginDto [memberEmail=" + memberEmail + ", memberPassword=" + memberPassword + "]";
	}
	
	
}
