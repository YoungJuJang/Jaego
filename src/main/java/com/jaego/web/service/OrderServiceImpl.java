package com.jaego.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaego.web.dto.MemberDto;
import com.jaego.web.dto.OrderDto;
import com.jaego.web.repository.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;

	@Override
	public void insertOrder(OrderDto orderDto) {
		orderDao.insertOrder(orderDto);
	}

	@Override
	public  List<MemberDto> orderMember(int lectureId) {
		return orderDao.orderMember(lectureId);
	}


}
