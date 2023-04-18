package com.sunny.app.user.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFileFrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String target = req.getRequestURI().substring(req.getContextPath().length());
		System.out.println(target);
		
			switch(target) {
			case "/userFile/userFileOk.uf" :
				System.out.println("frontController들어옴!");
				new UserFileOkController().execute(req, resp);
				break;
			case "/userFile/userFileDelete.uf" :
				System.out.println("frontController들어옴");
				new UserFileDeleteController().execute(req, resp);
		}
	}
}
