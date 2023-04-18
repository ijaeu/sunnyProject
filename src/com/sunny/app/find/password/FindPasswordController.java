package com.sunny.app.find.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;

public class FindPasswordController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
        int findQuestionNumber = Integer.parseInt(req.getParameter("findQuestionNumber"));
        String findPasswordAnswer = req.getParameter("findPasswordAnswer");

        // FindPasswordOkController로 데이터 전송
        req.setAttribute("userId", userId);
        req.setAttribute("findQuestionNumber", findQuestionNumber);
        req.setAttribute("findPasswordAnswer", findPasswordAnswer);
        req.getRequestDispatcher("/find/findPwOk.fp").forward(req, resp);
		
        System.out.println("FindPasswordController 진입");
        
	}
}
