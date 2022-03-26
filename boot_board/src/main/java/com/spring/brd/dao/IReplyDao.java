package com.spring.brd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.brd.dto.BoardDto;
import com.spring.brd.dto.ReplyDto;

@Mapper
public interface IReplyDao {
	public List<ReplyDto> reply_list(String reply_board_idx);
	public int reply_write(ReplyDto replyDto);
	public int reply_delete(String reply_idx);
}
