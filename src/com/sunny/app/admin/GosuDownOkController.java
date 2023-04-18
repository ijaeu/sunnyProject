package com.sunny.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;

public class GosuDownOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("gosuDownController!");
		AdminDAO adminDAO = new AdminDAO();
		
		int userNumber = Integer.valueOf(req.getParameter("userNumber"));
		
		//	유저 gradeNumber 100으로 down
		adminDAO.down(userNumber);
		
		resp.sendRedirect("/admin/gosuManage.ad");
	}

}
