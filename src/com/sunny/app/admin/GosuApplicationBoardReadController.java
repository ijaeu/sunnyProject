package com.sunny.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.GosuApplicationReadDAO;
import com.sunny.app.admin.vo.GosuApplicationReadVO;
import com.sunny.app.util.AdminUtils;

public class GosuApplicationBoardReadController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션체크
		if (!AdminUtils.sessionCheck(req)) {
			resp.sendRedirect("/admin/login.ad?login=noInfo");
			return;
		}
		
		int applyNumber = Integer.parseInt(req.getParameter("applyNumber"));
		System.out.println("applyNumber = " + applyNumber);
		
		// apply 정보 가져오기
		GosuApplicationReadDAO gosuApplicationReadDAO = new GosuApplicationReadDAO();
		GosuApplicationReadVO gosuApplicationReadVO = gosuApplicationReadDAO.applyRead(applyNumber);

		//	정보 담아서 보내기
		req.setAttribute("applydata", gosuApplicationReadVO);
		
		req.getRequestDispatcher("/app/admin/gosuApplicationBoardRead.jsp").forward(req, resp);
	}

}
