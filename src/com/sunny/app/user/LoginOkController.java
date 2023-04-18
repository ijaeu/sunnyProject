package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.user.dto.UserDTO;

public class LoginOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		int userNumber = 0;
		String userId = req.getParameter("userId");
		String userPassword = req.getParameter("userPassword");
		String remember = req.getParameter("remember");
		String path = null;
		HttpSession session = req.getSession();
		
		userDTO.setUserId(userId);
		userDTO.setUserPassword(userPassword);
		System.out.println("=============");
		try {
			userNumber = userDAO.login(userDTO);
			System.out.println(userNumber);
			path = "/main/mainOk.ma";
			session.setAttribute("userNumber", userNumber);
		} catch (NullPointerException e) {
			System.out.println("null!!");
			path = "/user/login.us?login=fail";
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("AAAA");
			e.printStackTrace();
		}
		
		if(remember != null && remember.equals("check")) {
			Cookie cookie = new Cookie("userId", userId);
			cookie.setMaxAge(60 * 60 * 24);	//쿠키 유효시간 1일(60초 * 60분 * 24시간)
			resp.addCookie(cookie);
		}
		
//		if(userNumber == -1) {
//			path = "/user/login.me";
//		} else {
//			path = "/story/storyListOk.st";
//		}
		
		

		
		resp.sendRedirect(path);
		
		
	}
}
