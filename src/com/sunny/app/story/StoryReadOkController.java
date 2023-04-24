package com.sunny.app.story;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		StoryDAO storyDAO = new StoryDAO();
		Integer storyNumber = Integer.valueOf(req.getParameter("storyNumber"));
		Integer userNumber = (Integer)req.getSession().getAttribute("userNumber");
		
		System.out.println("userNumber" + userNumber);
		
		
		Map<String, Integer>pageMap = new HashMap<>();
		pageMap.put("userNumber", userNumber);
		pageMap.put("storyNumber", storyNumber);
		
		StoryListVO storyListVO = storyDAO.select(pageMap);
		List<StoryFileDTO> storyFiles = new StoryFileDAO().select(storyNumber);
		System.out.println(storyFiles);
		
		storyDAO.updateReadCount(storyNumber);
		storyListVO.setStoryFiles(storyFiles);
		
		req.setAttribute("userNumber", userNumber);
		req.setAttribute("story", storyListVO);
		
		
		req.getRequestDispatcher("/app/story/storyRead.jsp").forward(req, resp);
	}

}

