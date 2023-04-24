package com.sunny.app.story;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.story.dao.StoryDAO;
import com.sunny.app.story.vo.StoryListVO;

public class StoryUpdateController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("storyUpdateController");
		
		Integer userNumber = (Integer)req.getSession().getAttribute("userNumber");
		int storyNumber = Integer.valueOf(req.getParameter("storyNumber"));
		System.out.println("수정페이지 storyNumber = " + storyNumber);
		StoryDAO storyDAO = new StoryDAO();
		
		Map<String, Integer>pageMap = new HashMap<>();
		
		pageMap.put("userNumber", userNumber);
		pageMap.put("storyNumber", storyNumber);
		
		
		StoryListVO storyListVO = storyDAO.select(pageMap);
		req.setAttribute("storyNumber" ,storyNumber);
		req.setAttribute("story" ,storyListVO);
		
		req.getRequestDispatcher("/app/story/storyUpdate.jsp").forward(req, resp);
	}

}
