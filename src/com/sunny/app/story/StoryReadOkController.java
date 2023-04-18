package com.sunny.app.story;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.story.dao.StoryDAO;
import com.sunny.app.story.file.dao.StoryFileDAO;
import com.sunny.app.story.file.dto.StoryFileDTO;
import com.sunny.app.story.vo.StoryListVO;

public class StoryReadOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int storyNumber = Integer.valueOf(req.getParameter("storyNumber"));
		StoryDAO storyDAO = new StoryDAO();
		StoryListVO storyListVO = storyDAO.select(storyNumber);
		List<StoryFileDTO> storyFiles = new StoryFileDAO().select(storyNumber);
		
		storyDAO.updateReadCount(storyNumber);
		
		storyListVO.setStoryFiles(storyFiles);
		
		req.setAttribute("story", storyListVO);
		
		
		req.getRequestDispatcher("/app/story/storyRead.jsp").forward(req, resp);
	}

}

