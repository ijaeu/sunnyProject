package com.sunny.app.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.dto.QuestionDTO;

public class QuestionUpdateController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		QuestionDAO questionDAO = new QuestionDAO();
		
		System.out.println("QuestionUpdateController 들어옴");
		
		// 페이지에서 넘어온 값 변수에 저장
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		int gosuNumber = Integer.valueOf(req.getParameter("gosuNumber"));
		
		// 값으로 수정할 페이지의 데이터를 불러옴
		QuestionDTO questionDTO = questionDAO.updateSelect(questionNumber);
		
		// 불러온 데이터를 req에 세팅
		req.setAttribute("question", questionDTO);
		req.setAttribute("gosuNumber", gosuNumber);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/question/questionUpdate.jsp").forward(req, resp);
	}

}
