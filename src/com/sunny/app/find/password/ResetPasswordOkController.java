package com.sunny.app.find.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.find.password.dao.FindPasswordDAO;
import com.sunny.app.user.dto.UserDTO;

public class ResetPasswordOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userNumber = Integer.parseInt(req.getParameter("userId"));
	    String userPassword = req.getParameter("newPassword");

	    UserDTO userDTO = new UserDTO();
	    userDTO.setUserNumber(userNumber);
	    userDTO.setUserPassword(userPassword);

	    System.out.println("ResetPasswordOkController 진입");

	    // 비밀번호 업데이트
	    FindPasswordDAO findPasswordDAO = new FindPasswordDAO();
	    findPasswordDAO.updatePassword(userDTO);

	    // 비밀번호 업데이트 성공 시 로그인 페이지로 이동
	    resp.sendRedirect(req.getContextPath() + "/user/login.us");   
		
	}
}
