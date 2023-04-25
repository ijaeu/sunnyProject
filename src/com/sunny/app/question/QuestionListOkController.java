package com.sunny.app.question;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.gosu.dao.GosuDAO;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.vo.GosuInfoVO;
import com.sunny.app.question.vo.QuestionListVO;

public class QuestionListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		QuestionDAO questionDAO = new QuestionDAO();
		GosuDAO gosuDAO = new GosuDAO();
		
		System.out.println("QuestionListOkController");
		int gosuNumber = Integer.parseInt(req.getParameter("gosuNumber"));
		System.out.println("gosuNumber : " + gosuNumber);

		GosuInfoVO gosuInfoVO = questionDAO.gosuInfo(gosuNumber);


//	    처음에는 0으로 설정(답변대기)
		Integer questionStatus = 0;
		
	    Map<String, Integer> questionMap = new HashMap<>();
	    questionMap.put("gosuNumber", gosuNumber);
	    questionMap.put("questionStatus", questionStatus);
	    System.out.println(questionStatus);
	    
	    List<QuestionListVO> questionList = questionDAO.getQuestionList(questionMap);
	    System.out.println(questionList);
	     
	    req.setAttribute("gosuInfo", gosuInfoVO);
	  	req.setAttribute("questionList", questionList);
	  	  
	    req.getRequestDispatcher("/app/question/questionList.jsp").forward(req, resp);
	   }

	}