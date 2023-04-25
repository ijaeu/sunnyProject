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
		
		QuestionDAO questionDAO = new QuestionDAO();

		System.out.println("QuestionListChangeController 들어옴");
		
		// 리스트 변경 버튼 클릭시 넘어온 데이터 저장
		int questionStatus = Integer.parseInt(req.getParameter("questionStatus"));
		int gosuNumber = Integer.parseInt(req.getParameter("gosuNumber"));
		
		// map 에 담아서 DAO -> 쿼리 실행 후 질문게시글리스트 담아옴
	    Map<String, Integer> questionMap = new HashMap<>();
	    questionMap.put("gosuNumber", gosuNumber);
	    questionMap.put("questionStatus", questionStatus);
	    List<QuestionListVO> questionList = questionDAO.getQuestionList(questionMap);

	    // gson 으로 다시 페이지로 보냄
		Gson gson = new Gson();
		JsonArray questions = new JsonArray();
		
		for(QuestionListVO question : questionList) {
			String questionJson = gson.toJson(question);
			questions.add(JsonParser.parseString(questionJson));
		}
	    
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter(); 
		out.print(questions.toString());
		// 꼭 닫아야함
		out.close();
	}
}