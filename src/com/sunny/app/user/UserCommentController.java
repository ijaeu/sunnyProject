package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.user.dto.UserDTO;

public class UserCommentController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("들어왔다!!!");
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("utf-8");
		
		userDTO.setUserComment(req.getParameter("userComment"));
		userDTO.setUserNumber((Integer)session.getAttribute("userNumber"));
		
		userDAO.userComment(userDTO);
		
	}

}
