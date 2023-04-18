package com.sunny.app.story.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.story.reply.dao.StoryReplyDAO;
import com.sunny.app.story.reply.dto.StoryReplyDTO;

public class StoryReplyWriteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StoryReplyDTO storyReplyDTO = new StoryReplyDTO();
		req.setCharacterEncoding("utf-8");
		
		storyReplyDTO.setStoryNumber(Integer.valueOf(req.getParameter("storyNumber")));
		storyReplyDTO.setUserNumber(Integer.valueOf(req.getParameter("userNumber")));
		storyReplyDTO.setReplyContent(req.getParameter("replyContent"));
		
		new StoryReplyDAO().insert(storyReplyDTO);
	}

}
