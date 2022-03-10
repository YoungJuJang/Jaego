package com.jaego.web.service;

import java.util.List;

import com.jaego.web.dto.MemberDto;
import com.jaego.web.dto.OrderDto;

public interface OrderService {

	
	public abstract void insertOrder(OrderDto orderDto);
	public abstract  List<MemberDto>  orderMember(int lectureId);

}
