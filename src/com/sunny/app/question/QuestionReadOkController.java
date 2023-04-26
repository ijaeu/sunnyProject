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

		QuestionDAO questionDAO = new QuestionDAO();

		System.out.println("QuestionReadOkController 들어옴");
		
		// 세션과 페이지에서 넘어온 값 변수에 저장
		Integer userNumber = (Integer)req.getSession().getAttribute("userNumber");
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		
		// 조회수 +1
		questionDAO.updateReadCount(questionNumber);

		// 쿼리에 담을 값을 map에 넣어서 보내고 read페이지 데이터를 return 받아옴
		Map<String, Integer>map = new HashMap<>();
		map.put("userNumber", userNumber);
		map.put("questionNumber", questionNumber);
		QuestionReadVO questionReadVO = questionDAO.questionRead(map);
		
		// 데이터를  req에 세팅함
		req.setAttribute("question", questionReadVO);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/question/questionRead.jsp").forward(req, resp);
		
	}

}
