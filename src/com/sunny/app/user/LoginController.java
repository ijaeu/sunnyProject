package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;

public class LoginController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
		            String name = cookie.getName(); // 쿠키 이름 가져오기
		            String value = cookie.getValue(); // 쿠키 값 가져오기
		            if (name.equals("userId")) {
		            	System.out.println("value = " +value);
		            	req.setAttribute("userId", value);
		            }
				}
			}
		
		req.getRequestDispatcher("/app/user/login.jsp").forward(req, resp);
		
	}
}
