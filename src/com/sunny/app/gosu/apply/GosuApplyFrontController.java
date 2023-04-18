package com.sunny.app.gosu.apply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.admin.AdminLoginController;

public class GosuApplyFrontController extends HttpServlet{

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
		System.out.println(target);
	
			switch(target) {
			
			 case "/gosuApply/gosuApply.ga":
		         new gosuApplyWriteController().execute(req, resp);
				 break;
			 case "/gosuApply/gosuApplyWriteOk.ga":
		         new gosuApplyWriteOkController().execute(req, resp);
				 break;
		}
	}
}
