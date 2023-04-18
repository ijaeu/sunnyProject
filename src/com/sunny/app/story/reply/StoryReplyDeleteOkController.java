package com.sunny.app.story.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.story.reply.dao.StoryReplyDAO;

public class StoryReplyDeleteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int replyNumber = Integer.parseInt(req.getParameter("replyNumber"));
		new StoryReplyDAO().delete(replyNumber);
	}

}
