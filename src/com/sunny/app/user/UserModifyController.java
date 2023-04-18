package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.user.dto.UserDTO;
import com.sunny.app.user.vo.UserVO;

public class UserModifyController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     System.out.println("UsermodifyController진입");
		  UserDAO userDAO = new UserDAO();
	      HttpSession session = req.getSession();
	      Integer userNumber = (Integer)session.getAttribute("userNumber");
	     
	      req.setAttribute("userInfo", userDAO.getUserInfo(userNumber));
	      
	      req.getRequestDispatcher("/app/user/userModify.jsp").forward(req, resp);

	   }
	}


