package com.sunny.app.follow;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;

public class FollowController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
	      Integer userNumber = (Integer)session.getAttribute("userNumber");
	      String path = null;
	      
	      resp.setContentType("text/html; charset=utf-8");
	      PrintWriter out = resp.getWriter();
	      if(userNumber == null) {
	        out.print("fail");
	        out.close();
	      }else {
	    	  out.print("success");
	    	  out.close();
	      }
	      
	}

}
