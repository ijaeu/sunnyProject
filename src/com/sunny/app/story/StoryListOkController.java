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
import com.sunny.app.story.vo.StoryListVO;

public class StoryListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StoryDAO storyDAO = new StoryDAO();
		int total = storyDAO.getTotal();
		
		String temp = req.getParameter("page");
		int page = temp == null ? 1 : Integer.valueOf(temp);
		
		int rowCount = 6;
		
		int pageCount = 5;
		
		int startRow = (page-1)*rowCount;
		
		int endPage = (int)(Math.ceil(page/(double)pageCount)*pageCount);
		
		int startPage = endPage - (pageCount - 1);
		
		int realEndPage = (int)Math.ceil(total/(double)rowCount);
		
		endPage = endPage > realEndPage ? realEndPage : endPage;
		
		boolean prev = startPage > 1;
		boolean next = endPage != realEndPage;
		

		Map<String, Integer>pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("rowCount", rowCount);
		
		List<StoryListVO> storys = storyDAO.selectAll(pageMap);
	
		req.setAttribute("storyList", storys);
		req.setAttribute("page", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("prev", prev);
		req.setAttribute("next", next);
		
		
		req.getRequestDispatcher("/app/story/storyList.jsp").forward(req,resp);
	}

}
