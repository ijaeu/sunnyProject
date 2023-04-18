package com.sunny.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.UserDetailDAO;
import com.sunny.app.admin.vo.UserDetailVO;
import com.sunny.app.util.AdminUtils;

public class UserDetailController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userNumber = Integer.parseInt(req.getParameter("userNumber"));
		
		UserDetailDAO userDetailDAO = new UserDetailDAO();
		UserDetailVO userDetailVO = userDetailDAO.userDetail(userNumber);
		
		// 세션체크
		if (!AdminUtils.sessionCheck(req)) {
			resp.sendRedirect("/admin/login.ad?login=noInfo");
			return;
		}
		
		// 회원정보
		
		req.setAttribute("userDetail", userDetailVO);
		
		req.getRequestDispatcher("/app/admin/userDetail.jsp").forward(req, resp);
	
	}

}
