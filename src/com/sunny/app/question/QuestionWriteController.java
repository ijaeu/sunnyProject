package com.sunny.app.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;

public class QuestionWriteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		
		HttpSession session = req.getSession();
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		Integer gosuNumber = Integer.parseInt(req.getParameter("gosuNumber"));
		System.out.println("userNumber = " + userNumber + " / gosuNumber = " + gosuNumber);
		
		String path = null;
		
		
		if(userNumber == null) {
			path = "/app/user/login.jsp";
		} else {
			path = "/app/question/questionWrite.jsp";
			req.setAttribute("userNumber", userNumber);
			req.setAttribute("gosuNumber", gosuNumber);
		}
		req.getRequestDispatcher(path).forward(req,resp);
	}

}
