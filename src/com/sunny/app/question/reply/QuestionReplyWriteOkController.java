package com.sunny.app.question.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.reply.dao.QuestionReplyDAO;
import com.sunny.app.question.reply.dto.QuestionReplyDTO;

public class QuestionReplyWriteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		QuestionReplyDTO questionReplyDTO = new QuestionReplyDTO();
		req.setCharacterEncoding("UTF-8");
		
		questionReplyDTO.setGosuNumber(Integer.valueOf(req.getParameter("gosuNumber")));
		questionReplyDTO.setQuestionNumber(Integer.valueOf(req.getParameter("questionNumber")));
		questionReplyDTO.setReplyContent(req.getParameter("replyContent"));
		questionReplyDTO.setUserNumber(Integer.valueOf(req.getParameter("userNumber")));
		
		new QuestionReplyDAO().insert(questionReplyDTO);
	}

}
