package com.sunny.app.story;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.story.dao.StoryDAO;

public class StoryUpdateController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int storyNumber = Integer.valueOf(req.getParameter("storyNumber"));
		StoryDAO storyDAO = new StoryDAO();
		
		req.setAttribute("story", storyDAO.select(storyNumber));
		req.getRequestDispatcher("/app/story/storyUpdate.jsp").forward(req, resp);
	}

}
