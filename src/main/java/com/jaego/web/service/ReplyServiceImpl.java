package com.jaego.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaego.web.dto.ReplyDto;
import com.jaego.web.repository.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService  {

 	@Autowired
    ReplyDao replyDao;
    
    @Override
    public List<ReplyDto> list(Map<String,Object> param) {
        return replyDao.list(param);
    }

    @Override
    public void create(ReplyDto replyDto) {
        replyDao.create(replyDto);
    }

    @Override
    public void delete(int replyId) {
   	 	replyDao.delete(replyId);
    }
    
	@Override
	public int replyTotalCount(int lectureroomId) {		
		  return replyDao.replyTotalCount(lectureroomId);
	}
    
	    
}
