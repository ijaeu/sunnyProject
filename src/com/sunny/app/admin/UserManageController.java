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
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.admin.vo.HeaderInfoVO;
import com.sunny.app.admin.vo.UserManageVO;
import com.sunny.app.util.AdminUtils;

public class UserManageController implements Execute {
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 세션체크
		int adminNumber = 0;
		if (AdminUtils.sessionCheck(req)==0) {
			resp.sendRedirect("app/admin/login.ad?login=noInfo");
		} else {
			adminNumber = AdminUtils.sessionCheck(req);
		}
		
		System.out.println("adminNumber = " + adminNumber);
		AdminDAO adminDAO = new AdminDAO();
		AdminDTO adminDTO = adminDAO.adminSelect(adminNumber);

		// 검색기능
		String searchWord = req.getParameter("searchWord");
		
		UserManageDAO userManageDAO = new UserManageDAO();
		HeaderInfoVO headerinfoVO = adminDAO.headerInfo();
		
		
		
		
		
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("searchWord", searchWord); 
		List<UserManageVO> users = userManageDAO.userInfo(pageMap);
		
		// 데이터 세팅
		req.setAttribute("adminInfo", adminDTO);
		req.setAttribute("headerInfo", headerinfoVO);
		req.setAttribute("userList", users);
		// 페이지 전환
		req.getRequestDispatcher("/app/admin/userManage.jsp").forward(req, resp);

	}
}
