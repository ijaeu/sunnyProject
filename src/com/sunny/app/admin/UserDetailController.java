package com.sunny.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;
import com.sunny.app.admin.dao.UserDetailDAO;
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.admin.vo.UserDetailVO;
import com.sunny.app.util.AdminUtils;

public class UserDetailController implements Execute{
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
		
		int userNumber = Integer.parseInt(req.getParameter("userNumber"));
		
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		UserDetailVO userDetailVO = userDetailDAO.userDetail(userNumber);
		
		
		// 데이터 세팅
		req.setAttribute("adminInfo", adminDTO);
		req.setAttribute("userDetail", userDetailVO);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/admin/userDetail.jsp").forward(req, resp);
	
	}

}
