package com.jaego.web.repository;

import java.util.List;

import com.jaego.web.dto.MemberDto;
import com.jaego.web.dto.OrderDto;

public interface OrderDao {
	
	public abstract void insertOrder(OrderDto orderDto);
	
	public abstract  List<MemberDto>  orderMember(int lectureId);

}
