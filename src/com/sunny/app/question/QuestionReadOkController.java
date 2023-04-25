package com.sunny.app.question;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.vo.QuestionReadVO;

public class QuestionReadOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("QuestionReadOkController 들어왔음");
		QuestionDAO questionDAO = new QuestionDAO();
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		Integer userNumber = (Integer)req.getSession().getAttribute("userNumber");

		System.out.println("questionNumber = " + questionNumber);
		System.out.println("userNumber = " + userNumber);
		
		Map<String, Integer>pageMap = new HashMap<>();
		pageMap.put("userNumber", userNumber);
		pageMap.put("questionNumber", questionNumber);
		
		
		
		QuestionReadVO questionReadVO = questionDAO.questionRead(pageMap);
		
		System.out.println("questionReadVO = " + questionReadVO);
		questionDAO.updateReadCount(questionNumber);
		
		req.setAttribute("question", questionReadVO);
		
		req.getRequestDispatcher("/app/question/questionRead.jsp").forward(req, resp);
		
	}

}
