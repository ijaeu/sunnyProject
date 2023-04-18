package com.sunny.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.util.AdminUtils;

public class AdminFrontController extends HttpServlet {

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
			
			 case "/admin/login.ad":
		         req.getRequestDispatcher("/app/admin/adminLogin.jsp").forward(req, resp);
				 break;
			 case "/admin/loginOk.ad":
		         new AdminLoginController().execute(req, resp);
				 break;
			 case "/admin/logoutOk.ad":
				 new LogoutOkController().execute(req, resp);
				 break;
		     case "/admin/select.ad":
			 		// 세션체크 
			 		if (!AdminUtils.sessionCheck(req)) {
			 			resp.sendRedirect("/admin/login.ad?login=noInfo");
			 			return;
			 		}
		    	  req.getRequestDispatcher("/app/admin/select.jsp").forward(req, resp);
		          break;
		     case "/admin/userManage.ad":
		    	  new UserManageController().execute(req, resp);
		    	  break;
		     case "/admin/userDetail.ad":
		    	  new UserDetailController().execute(req, resp);
		    	  break;
		     case "/admin/userKillOk.ad":
		    	  new UserKillOkController().execute(req, resp);
		    	  break;
		     case "/admin/gosuManage.ad":
		    	  new GosuManageController().execute(req, resp);
		    	  break;
		     case "/admin/gosuDetail.ad":
		    	  new GosuDetailController().execute(req, resp);
		    	  break;
		     case "/admin/gosuDownOk.ad":
		    	  new GosuDownOkController().execute(req, resp);
		    	  break;
		     case "/admin/gosuKillOk.ad":
		    	  new GosuKillOkController().execute(req, resp);
		    	  break;
		     case "/admin/gosuApplicationBoardList.ad":
		    	  new GosuApplicationBoardListController().execute(req, resp);
		    	  break;
		     case "/admin/gosuApplicationBoardRead.ad":
		    	  new GosuApplicationBoardReadController().execute(req, resp);
		    	  break;
		     case "/admin/gosuApplyOk.ad":
		    	  new GosuApplyOkController().execute(req, resp);
		    	  break;
		     case "/admin/gosuApplyNo.ad":
		    	  new GosuApplyNoController().execute(req, resp);
		    	  break;
		      }
		
		}
	}

