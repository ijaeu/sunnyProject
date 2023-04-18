package com.sunny.app.story.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoryReplyFrontController extends HttpServlet{

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
			case "/storyReply/storyReplyListOk.sr":
				new StoryReplyListOkController().execute(req, resp);
				break;
			case "/storyReply/storyReplyWriteOk.sr":
				new StoryReplyWriteOkController().execute(req, resp);
				break;
			case "/storyReply/storyReplyDeleteOk.sr":
				new StoryReplyDeleteOkController().execute(req, resp);
				break;
			case "/storyReply/storyReplyUpdateOk.sr":
				new StoryReplyUpdateOkController().execute(req, resp);
				break;
		}
	}
}
