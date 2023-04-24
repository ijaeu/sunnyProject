package com.sunny.app.question;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.vo.QuestionListVO;

public class QuestionListChangeController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("QuestionListChangeController");

		QuestionDAO questionDAO = new QuestionDAO();
		
		// 받은 값 저장
		Integer questionStatus = Integer.parseInt(req.getParameter("questionStatus"));
		int gosuNumber = Integer.parseInt(req.getParameter("gosuNumber"));
		
		// 값 확인
		System.out.println("qusetionStatus : " + questionStatus);
		System.out.println("gosuNumber : " + gosuNumber);
		
		// 저장
	    Map<String, Integer> questionMap = new HashMap<>();
	    questionMap.put("gosuNumber", gosuNumber);
	    questionMap.put("questionStatus", questionStatus);
	      
	    List<QuestionListVO> questionList = questionDAO.getQuestionList(questionMap);
	    
		Gson gson = new Gson();
		JsonArray questions = new JsonArray();
		
		for(QuestionListVO question : questionList) {
			String questionJson = gson.toJson(question);
			System.out.println(questionJson);
			
			questions.add(JsonParser.parseString(questionJson));
		}
	    
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter(); 
		out.print(questions.toString());
		out.close();
		
	}

}
