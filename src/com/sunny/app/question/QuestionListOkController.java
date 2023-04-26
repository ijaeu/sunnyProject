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
		
		System.out.println("QuestionListOkController 들어옴");

		int gosuNumber = Integer.parseInt(req.getParameter("gosuNumber"));
		GosuInfoVO gosuInfoVO = questionDAO.gosuInfo(gosuNumber);


	    // 처음 페이지 들어왔을때 보여줄 답변대기 게시글리스트(0)으로 설정
		Integer questionStatus = 0;
		// 쿼리에 담을 값 map에 넣어서 쿼리 실행 후 리스트 담아오기
	    Map<String, Integer> questionMap = new HashMap<>();
	    questionMap.put("gosuNumber", gosuNumber);
	    questionMap.put("questionStatus", questionStatus);
	    List<QuestionListVO> questionList = questionDAO.getQuestionList(questionMap);
	    
	    // req에 담아온 값들 세팅
	    req.setAttribute("gosuInfo", gosuInfoVO);
	  	req.setAttribute("questionList", questionList);
	  	
	  	// 페이지 이동
	    req.getRequestDispatcher("/app/question/questionList.jsp").forward(req, resp);
	   }

	}