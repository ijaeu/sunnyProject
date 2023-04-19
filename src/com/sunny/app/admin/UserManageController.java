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
		
		AdminDAO adminDAO = new AdminDAO();
		UserManageDAO userManageDAO = new UserManageDAO();
		HeaderInfoVO headerinfoVO = adminDAO.headerInfo();
		
		int adminNumber = 0;
		
		// 세션체크
		if (AdminUtils.sessionCheck(req)==0) {
			resp.sendRedirect("app/admin/login.ad?login=noInfo");
		} else {
			adminNumber = AdminUtils.sessionCheck(req);
		}
		
		System.out.println("adminNumber = " + adminNumber);
		
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("searchWord", searchWord); 
		List<UserManageVO> users = userManageDAO.userInfo(pageMap);
		
		req.setAttribute("headerInfo", headerinfoVO);
		req.setAttribute("userList", users);
		req.getRequestDispatcher("/app/admin/userManage.jsp").forward(req, resp);

	}
}
