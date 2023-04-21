package com.sunny.app.question;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.vo.GosuInfoVO;
import com.sunny.app.question.vo.QuestionListVO;

public class QuestionListChangeController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QuestionDAO questionDAO = new QuestionDAO();

		int gosuNumber = Integer.parseInt(req.getParameter("gosuNumber"));
		System.out.println("gosuNumber : " + gosuNumber);
		
		
		Integer qusetionStatus = Integer.parseInt(req.getParameter("questionStatuas"));
		
	    Map<String, Integer> questionMap = new HashMap<>();
	    questionMap.put("gosuNumber", gosuNumber);
	    questionMap.put("questionStatus", qusetionStatus);
	      
	    List<QuestionListVO> questions = questionDAO.getQuestionList(questionMap);
	    System.out.println("questions = " + questions);
	     
	  	req.setAttribute("questionList", questions);
		
		
	}

}
