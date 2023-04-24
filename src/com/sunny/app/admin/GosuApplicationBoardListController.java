package com.sunny.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;
import com.sunny.app.admin.dao.GosuApplicationListDAO;
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.admin.vo.GosuApplicationVO;
import com.sunny.app.util.AdminUtils;

public class GosuApplicationBoardListController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 세션체크
		int adminNumber = 0;
		if (AdminUtils.sessionCheck(req)==0) {
			resp.sendRedirect("/admin/login.ad?login=noInfo");
			return;
		} else {
			adminNumber = AdminUtils.sessionCheck(req);
		}
		
		System.out.println("adminNumber = " + adminNumber);
		AdminDAO adminDAO = new AdminDAO();
		AdminDTO adminDTO = adminDAO.adminSelect(adminNumber);		
				
		GosuApplicationListDAO gosuApplicationDAO = new GosuApplicationListDAO();

		
		Map<String, Integer> pageMap = new HashMap<>();
		
		List<GosuApplicationVO> applicationList = gosuApplicationDAO.applicationList(pageMap);
		
		// 데이터세팅
		req.setAttribute("adminInfo", adminDTO);
		req.setAttribute("applicationList", applicationList);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/admin/gosuApplicationBoardList.jsp").forward(req, resp);
	}

}
