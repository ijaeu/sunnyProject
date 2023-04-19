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
		System.out.println("findpasswordFrontController = " + target);
	
			switch(target) {
			case "/find/findPw.fp" :
//				req.getRequestDispatcher("/app/user/rePw.jsp").forward(req, resp);
				new FindPasswordController().execute(req, resp);
				break;
			case "/find/findPwOk.fp" :
				new FindPasswordOkController().execute(req, resp);
				break;
			case "/find/resetPw.fp" :
				req.getRequestDispatcher("/app/user/rePwOk.jsp").forward(req, resp);
//				new ResetPasswordController().execute(req, resp);
				break;			
			case "/find/resetPwOk.fp" :
				new ResetPasswordOkController().execute(req, resp);
				break;
		}
	}
}
