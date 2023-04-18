package com.sunny.app.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;

public class CheckNickOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		
		String userNickname = req.getParameter("userNickname");
		boolean isTrue = userDAO.checkNick(userNickname);
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print(isTrue?"사용 가능한 닉네임입니다.":"중복된 닉네임입니다.");
		out.close();
	}

}
