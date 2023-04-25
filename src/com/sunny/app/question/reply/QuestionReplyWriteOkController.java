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

		System.out.println("QuestionReplyWriteOkController");
		QuestionReplyDTO questionReplyDTO = new QuestionReplyDTO();
		req.setCharacterEncoding("UTF-8");
		
		int gosuNumber = Integer.valueOf(req.getParameter("gosuNumber"));
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		String replyContent = req.getParameter("replyContent");
		int userNumber = Integer.valueOf(req.getParameter("userNumber"));
		
		System.out.println("gosuNumber = " + gosuNumber + "questionNumber = " + questionNumber + 
				"replyContent = " + replyContent + "userNumber = " + userNumber);
		
		questionReplyDTO.setGosuNumber(gosuNumber);
		questionReplyDTO.setQuestionNumber(questionNumber);
		questionReplyDTO.setReplyContent(replyContent);
		questionReplyDTO.setUserNumber(userNumber);
		
		new QuestionReplyDAO().insert(questionReplyDTO);
	}

}
