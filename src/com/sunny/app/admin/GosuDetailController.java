package com.sunny.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;
import com.sunny.app.admin.dao.GosuDetailDAO;
import com.sunny.app.admin.vo.GosuDetailVO;
import com.sunny.app.admin.vo.HeaderInfoVO;
import com.sunny.app.util.AdminUtils;

public class GosuDetailController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userNumber = Integer.parseInt(req.getParameter("userNumber"));
		
		GosuDetailDAO gosuDetailDAO = new GosuDetailDAO();
		GosuDetailVO gosuDetailVO = gosuDetailDAO.gosuDetail(userNumber);
		
		// 세션체크
		if (!AdminUtils.sessionCheck(req)) {
			resp.sendRedirect("/admin/login.ad?login=noInfo");
			return;
		}
		
		// 회원정보
		req.setAttribute("gosuDetail", gosuDetailVO);
		req.getRequestDispatcher("/app/admin/gosuDetail.jsp").forward(req, resp);
		

	
	}

}
