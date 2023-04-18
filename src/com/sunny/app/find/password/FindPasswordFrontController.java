package com.sunny.app.find.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindPasswordFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().substring(req.getContextPath().length());
	
			switch(target) {
			case "/find/findPw.fp" :
				req.getRequestDispatcher("/app/user/RePw.jsp").forward(req, resp);
				break;
			case "/find/findPwOk.fp" :
				new FindPasswordOkController().execute(req, resp);
				break;
			case "/find/resetPwOk.fp" :
				new ResetPasswordOkController().execute(req, resp);
				break;
		}
	}
}

