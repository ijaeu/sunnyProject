package com.sunny.app.question.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.reply.dao.QuestionReplyDAO;
import com.sunny.app.question.reply.dto.QuestionReplyDTO;

public class QuestionReplyWriteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		QuestionReplyDTO questionReplyDTO = new QuestionReplyDTO();

		System.out.println("QuestionReplyWriteOkController 들어옴");
		
		// 입력한 값 변수에 저장
		int userNumber = Integer.valueOf(req.getParameter("userNumber"));
		int gosuNumber = Integer.valueOf(req.getParameter("gosuNumber"));
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		String replyContent = req.getParameter("replyContent");

		// 저장한 값 questionReplyDTO에 담기
		questionReplyDTO.setGosuNumber(gosuNumber);
		questionReplyDTO.setQuestionNumber(questionNumber);
		questionReplyDTO.setReplyContent(replyContent);
		questionReplyDTO.setUserNumber(userNumber);
		
		// questionReplyDTO에 저장한 데이터 DAO -> 쿼리로 DB에 저장
		new QuestionReplyDAO().insert(questionReplyDTO);
		
		// 댓글이 고수의 답변 확인하기 위한 데이터 저장
		Map<String, Integer> map = new HashMap<>();
		map.put("userNumber", userNumber);
		map.put("questionNumber", questionNumber);
		
		// 고수의 답변 확인 쿼리
		new QuestionDAO().updateQuestionStatus(map);
	}
}
