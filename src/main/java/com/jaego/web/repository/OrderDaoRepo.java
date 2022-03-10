package com.jaego.web.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaego.web.dto.MemberDto;
import com.jaego.web.dto.OrderDto;

@Repository
public class OrderDaoRepo implements OrderDao{

	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	public OrderDaoRepo(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}


	@Override
	public void insertOrder(OrderDto orderDto) {
		sqlSessionTemplate.insert("insertOrder",orderDto);
		
	}


	@Override
	public List<MemberDto> orderMember(int lectureId) {
		return sqlSessionTemplate.selectList("orderMember",lectureId);
	}

	
	
}
