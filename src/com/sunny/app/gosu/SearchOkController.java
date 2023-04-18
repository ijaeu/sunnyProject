package com.sunny.app.gosu;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.gosu.dao.GosuDAO;
import com.sunny.app.gosu.vo.GosuVO;
import com.sunny.app.user.vo.UserVO;

public class SearchOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		  System.out.println("들어왔다");
		  
		  GosuDAO gosuDAO = new GosuDAO();
	
	      int total = gosuDAO.getTotal();
	      String temp = req.getParameter("page");
	      int page = temp == null ? 1 : Integer.valueOf(temp);
	      
//	      한 페이지에 몇 개의 게시물? 10개
	      int rowCount = 3;
//	      페이지 버튼 세트는? 5개씩
	      int pageCount = 5;
	      int startRow = (page-1) * rowCount;
	      int endPage = (int)(Math.ceil(page/(double)pageCount) * pageCount);
	      int startPage = endPage - (pageCount - 1);
	      int realEndPage = (int)Math.ceil(total / (double)rowCount);
	      endPage = endPage > realEndPage ? realEndPage : endPage;
	      boolean prev = startPage > 1;
	      boolean next = endPage != realEndPage;
	      
	      Map<String, Integer> pageMap = new HashMap<>();
	      pageMap.put("startRow", startRow);
	      pageMap.put("rowCount", rowCount);
	      
	      List<GosuVO> gosus = gosuDAO.selectAll(pageMap);
	      
		  req.setAttribute("gosus", gosus);
	      req.setAttribute("page", page);
	      req.setAttribute("startPage", startPage);
	      req.setAttribute("endPage", endPage);
	      req.setAttribute("prev", prev);
	      req.setAttribute("next", next);

	      req.getRequestDispatcher("/app/gosu/search.jsp").forward(req, resp);
	}

}
