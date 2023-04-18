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
import com.sunny.app.admin.dao.UserManageDAO;
import com.sunny.app.admin.vo.HeaderInfoVO;
import com.sunny.app.admin.vo.UserManageVO;
import com.sunny.app.util.AdminUtils;

public class UserManageController implements Execute {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String searchWord = req.getParameter("searchWord");
		System.out.println("=====================");
		System.out.println(searchWord);
		
		AdminDAO adminDAO = new AdminDAO();
		UserManageDAO userManageDAO = new UserManageDAO();
		HeaderInfoVO headerinfoVO = adminDAO.headerInfo();
		
		// 세션체크
		if (!AdminUtils.sessionCheck(req)) {
			resp.sendRedirect("/admin/login.ad?login=noInfo");
			return;
		}
		
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("searchWord", searchWord); 
		List<UserManageVO> users = userManageDAO.userInfo(pageMap);
		
		req.setAttribute("headerInfo", headerinfoVO);
		req.setAttribute("userList", users);
		req.getRequestDispatcher("/app/admin/userManage.jsp").forward(req, resp);

	}
}
