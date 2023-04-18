package com.sunny.app.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sunny.app.Execute;
import com.sunny.app.gosu.dao.GosuDAO;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.vo.QuestionVO;

public class myPageQuestionListController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("myPageQuestionList들어왔다아아 ");
		
		
		HttpSession session = req.getSession();
		QuestionDAO questionDAO = new QuestionDAO();
		GosuDAO gosuDAO = new GosuDAO();
		int userNumber = 0;
		int gosuNumber =0;
		System.out.println("=======================");
		System.out.println(req.getParameter("userNumber"));
		System.out.println("=======================");
		
		if(req.getParameter("userNumber") == null) {
			userNumber = (Integer) session.getAttribute("userNumber");
		}else {
			userNumber = Integer.parseInt(req.getParameter("userNumber"));
		}
		
		System.out.println(userNumber);

		gosuNumber = gosuDAO.getGosuNumber(userNumber);
		
		System.out.println(gosuNumber);
		
		int questionStatus = 0;
		if(req.getParameter("questionStatus")==null) {
			questionStatus = 0;
		}else {
		questionStatus=Integer.parseInt(req.getParameter("questionStatus"));	
		}
		
		Map<String, Integer> gosuQ = new HashMap<>();
		gosuQ.put("gosuNumber", gosuNumber);
		gosuQ.put("questionStatus", questionStatus);

		
		List<QuestionVO> questionList = questionDAO.getMypageList(gosuQ);
		System.out.println(questionList);
		
		Gson gson = new Gson();
		JsonArray questions = new JsonArray();
		
		for(QuestionVO question : questionList) {
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
