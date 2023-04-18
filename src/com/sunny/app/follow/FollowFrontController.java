package com.sunny.app.follow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.user.file.UserFileOkController;

public class FollowFrontController extends HttpServlet{

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
			case "/follow/followerList.fo" :
				new FollowerListOkController().execute(req, resp);
				break;
			case "/follow/followingList.fo" :
				new FollowingListOkController().execute(req, resp);
				break;
			case "/follow/followInsert.fo" :
				new FollowInsertOkController().execute(req, resp);
				break;
			case "/follow/followDelete.fo" :
				new FollowDeleteOkController().execute(req, resp);
				break;
		}
	}
}
