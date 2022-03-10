package com.jaego.web.repository;

import java.util.List;
import java.util.Map;

import com.jaego.web.dto.ReplyDto;

public interface ReplyDao {

	public List<ReplyDto> list(Map<String, Object> param);

	public void create(ReplyDto replyDto);

	public void delete(int replyId);

	public int replyTotalCount(int lectureroomId);

}
