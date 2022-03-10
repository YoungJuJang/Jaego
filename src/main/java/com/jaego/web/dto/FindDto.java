package com.jaego.web.dto;


import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


@Component("findDto")
@Alias("findDto")
public class FindDto {
		
	private int memberId;
	
	private String memberPassword;
	
	@NotEmpty(message="이메일을 입력하세요")
	private String memberEmail;
	
	@NotEmpty(message="연락처를 입력하세요")
	private String memberPhone;
	
	@NotEmpty(message="이름을 입력하세요")
	private String memberName;
	
	private String newPassword;
	
	public FindDto() {
		super();
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	

}
