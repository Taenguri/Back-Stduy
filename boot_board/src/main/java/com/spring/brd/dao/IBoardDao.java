package com.spring.brd.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.brd.dto.BoardDto;

@Mapper
public interface IBoardDao {
	public List<BoardDto> list();
	public int write(BoardDto boardDto);
	public BoardDto viewDto(String board_idx);
	public int deleteDto(String board_idx);
	public int updateDto(BoardDto boardDto);
	public int hit(String board_idx);
}
