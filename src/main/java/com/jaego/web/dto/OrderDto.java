package com.jaego.web.dto;

import org.apache.ibatis.type.Alias;

@Alias(value="orderDto")
public class OrderDto {
	private String ordersId;
	private int LectureId;
	private int memberId;
	
	
	public OrderDto(String ordersId, int lectureId, int memberId) {
		super();
		this.ordersId = ordersId;
		LectureId = lectureId;
		this.memberId = memberId;
	}
	public String getOrderId() {
		return ordersId;
	}
	public void setOrderId(String orderId) {
		this.ordersId = orderId;
	}
	public int getLectureId() {
		return LectureId;
	}
	public void setLectureId(int lectureId) {
		LectureId = lectureId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

}
