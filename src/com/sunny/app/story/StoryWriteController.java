package com.sunny.app.story;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;

public class StoryWriteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("storyWriteController 왔다.");
	      UserDAO userDAO = new UserDAO();
	      HttpSession session = req.getSession();
	      Integer userNumber = (Integer)session.getAttribute("userNumber");
	      System.out.println(userNumber);
	      String path = null;
	      
	      if(userNumber == null) {
	         path = "/app/user/login.jsp";
	      }else {
	         path ="/app/story/storyWrite.jsp";
	      }
	      
	      req.getRequestDispatcher(path).forward(req, resp);
	   }


}
