package com.sunny.app.question;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionFrontController extends HttpServlet{

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
			 case "/question/questionListOk.qs":
		         new QuestionListOkController().execute(req, resp);
		         break;
		      case "/question/questionReadOk.qs":
		    	 new QuestionReadOkController().execute(req, resp);
		         break;
		      case "/question/questionWrite.qs":
		    	 new QuestionWriteController().execute(req, resp);
		         break;
		      case "/question/questionWriteOk.qs":
		    	  new QuestionWriteOkController().execute(req, resp);
		         break;
		}
	}
}
