package com.sunny.app.question.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionReplyFrontController extends HttpServlet{

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
			case "/questionReply/questionReplyListOk.qr":
		         new QuestionReplyListOkController().execute(req, resp);
		         break;
			case "/questionReply/questionReplyWriteOk.qr":
				new QuestionReplyWriteOkController().execute(req, resp);
				break;
			case "/questionReply/questionReplyDeleteOk.qr":
				new QuestionReplyDeleteOkController().execute(req, resp);
				break;
			case "/questionReply/questionUpdateOk.qr":
				new QuestionReplyUpdateOkController().execute(req, resp);
				break;
		}
	}
}
