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
		System.out.println("QuestionUpdateController 들어옴");
		
		Integer userNumber = (Integer)req.getSession().getAttribute("userNumber");
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		int gosuNumber = Integer.valueOf(req.getParameter("gosuNumber"));
		QuestionDAO questionDAO = new QuestionDAO();
		
		
		QuestionDTO questionDTO = questionDAO.updateSelect(questionNumber);
		req.setAttribute("question", questionDTO);
		req.setAttribute("gosuNumber", gosuNumber);
		
		req.getRequestDispatcher("/app/question/questionUpdate.jsp").forward(req, resp);
	}

}
