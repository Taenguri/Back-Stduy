package com.spring.brd;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.brd.dao.IBoardDao;
import com.spring.brd.dao.IReplyDao;
import com.spring.brd.dto.BoardDto;
import com.spring.brd.dto.ReplyDto;

@Controller
public class MyController {

	@Autowired
	IBoardDao boardDao;
	
	@Autowired
	IReplyDao replyDao;
	
	@GetMapping("/")
	public String root() {
		return "redirect:listForm";
	}
	
	@GetMapping("/listForm")
	public String listForm(Model model) {
		List<BoardDto> list = boardDao.list();
		model.addAttribute("list", list);
		System.out.println(list);
		return "listForm";
	}
	@GetMapping("/writeForm")
	public void writeForm() {
	}
	
	@PostMapping("/writeAction")
	@ResponseBody
	public String writeAction(BoardDto boardDto ){
		
		int result = boardDao.write(boardDto);
		if(result == 1) {
			return "<script>alert('글 쓰기 성공'); location.href='/listForm';</script>";
		}else {
			return "<script>alert('글 쓰기 실패'); location.href='/writeForm';</script>";
		}
	}
	
//	contentForm?board_idx?${dto.board_title }
	@GetMapping("/contentForm")
	public String contentForm(String board_idx, Model model) {
		
		boardDao.hit(board_idx);
		
		BoardDto dto = boardDao.viewDto(board_idx);
		model.addAttribute("dto",dto);
		
		// 댓글 리스트 가져오기
		List<ReplyDto> reply_list = replyDao.reply_list(board_idx);
		model.addAttribute("reply_list",reply_list);
		
		return "contentForm";
	}
	
	@GetMapping("/deleteAction")
	@ResponseBody
	public String deleteAction(String board_idx) {
		
		int result = boardDao.deleteDto(board_idx);
		if(result == 1) {
			return "<script>alert('글 삭제 성공'); location.href='/listForm';</script>";
		}else {
			return "<script>alert('글 삭제 실패'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
		}
		
	}
	
	@PostMapping("/updateAction")
	@ResponseBody
	public String updateAction(BoardDto boardDto) {
		
		int result = boardDao.updateDto(boardDto);
		if(result == 1) {
			return "<script>alert('글 수정 성공'); location.href='/listForm';</script>";
		}else {
			return "<script>alert('글 수정 실패'); location.href='/contentForm?board_idx=" + boardDto.getBoard_idx() + "';</script>";
		}
	}
	
	
	@PostMapping("writeReplyAction")
	@ResponseBody
	public String writeReplyAction(ReplyDto replyDto ){
		
		int result = replyDao.reply_write(replyDto);
		if(result == 1) {
			return "<script>alert('댓글 쓰기 성공'); location.href='/contentForm?board_idx=" + replyDto.getReply_board_idx()+ "';</script>";
		}else {
			return "<script>alert('댓글 쓰기 실패'); location.href='/contentForm?board_idx=" + replyDto.getReply_board_idx()+ "';</script>";
		}
	}
	
	
	@GetMapping("/deleteReplyAction")
	@ResponseBody
	public String deleteReplyAction(String reply_idx,String board_idx) {
		
		int result = replyDao.reply_delete(reply_idx);
		if(result == 1) {
			return "<script>alert('댓글 삭제 성공'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
		}else {
			return "<script>alert('댓글 삭제 실패'); location.href='/contentForm?board_idx=" + board_idx + "';</script>";
		}
		
	}
	
}
