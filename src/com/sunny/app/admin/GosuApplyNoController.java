package com.sunny.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;

public class GosuApplyNoController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AdminDAO adminDAO = new AdminDAO();
		
		int userNumber = Integer.valueOf(req.getParameter("userNumber"));
		int applyNumber = Integer.valueOf(req.getParameter("applyNumber"));
		
		adminDAO.negative(userNumber);
		adminDAO.deleteGosuNumber(userNumber);
		adminDAO.deleteGosuApply(applyNumber);
			
		resp.sendRedirect("/admin/gosuApplicationBoardList.ad");
		
	}

}
