package com.sunny.app.story;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StoryFrontController extends HttpServlet {

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
	
			switch(target) {
			case "/story/storyListOk.st" :
				new StoryListOkController().execute(req, resp);
				break;
			case "/story/storyReadOk.st" :
				new StoryReadOkController().execute(req, resp);
				break;
			case "/story/storyWrite.st" :
				new StoryWriteController().execute(req, resp);
				break;
			case "/story/storyWriteOk.st" :
				new StoryWriteOkController().execute(req, resp);
				break;
			case "/story/storyDeleteOk.st" :
				new StoryDeleteOkController().execute(req, resp);
				break;
			case "/story/storyUpdate.st" :
				new StoryUpdateController().execute(req, resp);
				break;
			case "/story/storyUpdateOk.st" :
				new StoryUpdateOkController().execute(req, resp);
				break;
		}
	}
}
