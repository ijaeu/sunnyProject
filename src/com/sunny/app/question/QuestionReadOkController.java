package com.sunny.app.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.vo.QuestionVO;

public class QuestionReadOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		QuestionDAO questionDAO = new QuestionDAO();
		QuestionVO questionVO = questionDAO.select(questionNumber);
		
		questionDAO.updateReadCount(questionNumber);
		
		req.setAttribute("question", questionVO);
		
		req.getRequestDispatcher("/app/question/questionRead.jsp").forward(req, resp);
		
	}

}
