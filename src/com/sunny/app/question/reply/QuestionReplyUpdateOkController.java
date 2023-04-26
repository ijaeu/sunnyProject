package com.sunny.app.question.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.reply.dao.QuestionReplyDAO;
import com.sunny.app.question.reply.dto.QuestionReplyDTO;

public class QuestionReplyUpdateOkController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		
		QuestionReplyDTO questionReplyDTO = new QuestionReplyDTO();
		
		System.out.println("QuestionReplyUpdateOkController 들어옴");
		
		// 페이지에서 넘어온 값 변수에 저장
		int replyNumber = Integer.parseInt(req.getParameter("replyNumber"));

		// 입력한 댓글 내용 questionReplyDTO에 저장
		questionReplyDTO.setReplyNumber(replyNumber);
		questionReplyDTO.setReplyContent(req.getParameter("replyContent"));
		
		// 입력한 내용으로 댓글 업데이트
		new QuestionReplyDAO().update(questionReplyDTO);
	}

}
