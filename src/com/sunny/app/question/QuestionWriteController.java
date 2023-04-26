package com.sunny.app.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.util.UserUtils;

public class QuestionWriteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		
		System.out.println("QuestionWriteController 들어옴");
		
		// 세션체크
		int userNumber = 0;
		if (UserUtils.sessionCheck(req) == 0) {
			resp.sendRedirect("/user/login.us?login=noInfo");
			return;
		} else {
			userNumber = UserUtils.sessionCheck(req);
		}
		
		// 페이지의 gosuNumber 값 가져오기
		Integer gosuNumber = Integer.parseInt(req.getParameter("gosuNumber"));
		
		// req에 데이터 세팅
		req.setAttribute("gosuNumber", gosuNumber);
		req.setAttribute("userNumber", userNumber);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/question/questionWrite.jsp").forward(req,resp);
	}

}
