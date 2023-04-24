package com.sunny.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;
import com.sunny.app.admin.dao.GosuDetailDAO;
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.admin.vo.GosuDetailVO;
import com.sunny.app.admin.vo.HeaderInfoVO;
import com.sunny.app.util.AdminUtils;

public class GosuDetailController implements Execute{
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
		
		
		int userNumber = Integer.parseInt(req.getParameter("userNumber"));
		
		GosuDetailDAO gosuDetailDAO = new GosuDetailDAO();
		GosuDetailVO gosuDetailVO = gosuDetailDAO.gosuDetail(userNumber);
		
		
		// 회원정보
		req.setAttribute("adminInfo", adminDTO);
		req.setAttribute("gosuDetail", gosuDetailVO);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/admin/gosuDetail.jsp").forward(req, resp);
		

	
	}

}
