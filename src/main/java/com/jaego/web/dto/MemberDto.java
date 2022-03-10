package com.jaego.web.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.jaego.web.exception.IdPasswordNotMatchingException;

// 회원 정보를 저장하는 클래스

@Component("memberDto")
@Alias("memberDto")
public class MemberDto {
		
	private int memberId;
	
	@NotEmpty(message="이메일을 입력하세요")
	@Length(min=4, message="이메일은 최소 4자 이상이어야 합니다")
	private String memberEmail1;
	
	@NotEmpty(message="이메일을 선택하세요")
	private String memberEmail2;
	
	@NotEmpty(message="비밀번호를 입력하세요")
	@Length(min=8, message="비밀번호는 최소 8자 이상이어야 합니다")
	private String memberPassword;
	
	@NotEmpty(message="비밀번호를 확인하세요")
	private String confirmPassword;
	
	@NotEmpty(message="이름을 입력하세요")
	private String memberName;
	
	private String memberPhone1;
	
	@NotEmpty(message="연락처를 입력하세요")
	@Length(min=3, message="연락처는 최소 3자 이상이어야 합니다")
	private String memberPhone2;
	
	@NotEmpty(message="연락처를 입력하세요")
	@Length(min=3, message="연락처는 최소 3자 이상이어야 합니다")
	private String memberPhone3;
	
	@NotEmpty(message="성별을 선택하세요")
	private String memberGender;
	
	@NotEmpty(message="나이대를 선택하세요")
	private String memberAge;
	
	private int memberMentorStatus;
	private Timestamp MemberRegdate;
	
	
	
	public MemberDto() {}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberEmail1() {
		return memberEmail1;
	}

	public void setMemberEmail1(String memberEmail1) {
		this.memberEmail1 = memberEmail1;
	}

	public String getMemberEmail2() {
		return memberEmail2;
	}

	public void setMemberEmail2(String memberEmail2) {
		this.memberEmail2 = memberEmail2;
	}

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPhone1() {
		return memberPhone1;
	}

	public void setMemberPhone1(String memberPhone1) {
		this.memberPhone1 = memberPhone1;
	}

	public String getMemberPhone2() {
		return memberPhone2;
	}

	public void setMemberPhone2(String memberPhone2) {
		this.memberPhone2 = memberPhone2;
	}

	public String getMemberPhone3() {
		return memberPhone3;
	}

	public void setMemberPhone3(String memberPhone3) {
		this.memberPhone3 = memberPhone3;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public int getMemberMentorStatus() {
		return memberMentorStatus;
	}

	public void setMemberMentorStatus(int memberMentorStatus) {
		this.memberMentorStatus = memberMentorStatus;
	}

	public Timestamp getMemberRegdate() {
		return MemberRegdate;
	}

	public void setMemberRegdate(Timestamp memberRegdate) {
		MemberRegdate = memberRegdate;
	}




	// 비밀번호 변경을 구현하는 메서드
	public void changePassword(String oldPassword, String newPassword) {
		if(!memberPassword.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
			this.memberPassword = newPassword;
	}

}
