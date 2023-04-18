package com.sunny.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;

public class LogoutOkController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("adminLogoutController탐.");
		
		// 세션의 모든 값 삭제
		req.getSession().invalidate();
		// 페이지 이동처리
		resp.sendRedirect("/admin/login.ad?login=logout");
	}

}
