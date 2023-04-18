package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;

public class UserDropController implements Execute{
@Override
public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession();
	UserDAO userDAO = new UserDAO();
	Integer userNumber = (Integer)session.getAttribute("userNumber");
	
	userDAO.userDrop(userNumber);
	
	req.getSession().invalidate();

	}
}
