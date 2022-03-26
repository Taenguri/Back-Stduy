package com.spring.brd.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {
	private int reply_idx;
	private String reply_name;
	private String reply_content;
	private Date reply_date;
	private int reply_board_idx;

}
