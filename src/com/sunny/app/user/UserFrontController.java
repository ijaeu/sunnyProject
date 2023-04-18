package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserFrontController extends HttpServlet{

	
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

		case "/user/myPage.us" :
			new MyPageController().execute(req, resp);
			break;
		case "/user/myPageOk.us" :
			System.out.println("!!!");
			new MyPageOkController().execute(req, resp);
			break;
		case "/user/myPageQuestionList.us" :
			System.out.println("고수인사람");
			new myPageQuestionListController().execute(req, resp);
			break;
		case "/user/userCommentOk.us":
			new UserCommentController().execute(req, resp);
			break;
		case "/user/userDrop.us":
			req.getRequestDispatcher("/app/user/userDrop.jsp").forward(req, resp);
			break;
		case "/user/userDropOk.us" : 
			new UserDropController().execute(req, resp);
			req.getRequestDispatcher("/app/main/main.jsp").forward(req, resp);
			break;
		case "/user/userModify.us":
			new UserModifyController().execute(req, resp);
			break;
		case "/user/userModifyOk.us" :
			new UserModifyOkController().execute(req, resp);
			resp.sendRedirect("/user/myPageOk.us");
			break;
		case "/user/checkPwOk.us":
			new CheckPwOkController().execute(req,resp);
			break;
		case "/user/checkNickOk.us":
			new CheckNickOkController().execute(req,resp);
			break;
		case "/user/join.us":
			req.getRequestDispatcher("/app/user/join.jsp").forward(req, resp);
			break;
		case "/user/joinOk.us":
//			req.getRequestDispatcher("/app/user/joinOk.jsp").forward(req, resp);
			new JoinOkController().execute(req, resp);
			break;
		case "/user/checkIdOk.us":
			new CheckIdOkController().execute(req,resp);
			break;
		case "/user/login.us":
			new LoginController().execute(req,resp);
			break;
		case "/user/loginOk.us":
			new LoginOkController().execute(req,resp);
			break;
		case "/user/logoutOk.us":
			new LogoutOkController().execute(req,resp);
			break;
		case "/user/result.us":
			req.getRequestDispatcher("/app/user/joinOk.jsp").forward(req, resp);
			break;
		}
	}
}
