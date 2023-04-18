package com.sunny.app.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.user.dto.UserDTO;

public class CheckPwOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserNumber(Integer.valueOf(req.getParameter("userNumber")));
		userDTO.setUserPassword(req.getParameter("userPassword"));
		
		boolean isTrue = userDAO.checkPw(userDTO);
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		out.print(isTrue? "비밀번호가 일치하지 않습니다.":"비밀번호가 일치합니다.");
		out.close();
		
	}

}
