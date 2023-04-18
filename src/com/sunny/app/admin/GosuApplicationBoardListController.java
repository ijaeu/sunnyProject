package com.sunny.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.GosuApplicationListDAO;
import com.sunny.app.admin.vo.GosuApplicationVO;
import com.sunny.app.util.AdminUtils;

public class GosuApplicationBoardListController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		GosuApplicationListDAO gosuApplicationDAO = new GosuApplicationListDAO();
		
		// 세션체크
		if (!AdminUtils.sessionCheck(req)) {
			resp.sendRedirect("app/admin/login.ad?login=noInfo");
		}
		
		
		Map<String, Integer> pageMap = new HashMap<>();
		
		List<GosuApplicationVO> applicationList = gosuApplicationDAO.applicationList(pageMap);
		
		req.setAttribute("applicationList", applicationList);
		
		req.getRequestDispatcher("/app/admin/gosuApplicationBoardList.jsp").forward(req, resp);
	}

}
