package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;

public class MyPageController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	      Integer userNumber = (Integer)session.getAttribute("userNumber");
	      String path = null;
	      UserDAO userDAO = new UserDAO();
	      
	      if(userNumber == null) {
	         path = "/user/login.us";
	      }else {
	    	  path ="/user/myPageOk.us";
	      }
	      
	      resp.sendRedirect(path);

	     
	}

}
