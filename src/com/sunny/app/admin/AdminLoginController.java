package com.sunny.app.admin;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.util.AdminUtils;

public class AdminLoginController implements Execute{
	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");

		AdminDTO adminDTO = new AdminDTO();
		AdminDAO adminDAO = new AdminDAO();
		final String path;
		
		
		String adminId = (String)req.getParameter("adminId");
		String adminPW = (String)req.getParameter("adminPassword");
		
		// sha256 비밀번호 암호화 처리 
		adminPW = AdminUtils.pwSha256(adminPW);
		
		adminDTO.setAdminId(adminId);
		adminDTO.setAdminPassword(adminPW);
        
		List<AdminDTO> adminList = adminDAO.select(adminDTO);
		System.out.println("adminList size = " + adminList.size());
		
		if(adminList.size() > 0) {
			System.out.println("맞음");
			path = "/admin/select.ad";
			req.getSession().setAttribute("adminNumber", adminList.get(0).getAdminNumber());
		}else {
			System.out.println("아이디 or 비밀번호 틀림");
			path = "/admin/login.ad?login=fail";
			
		}
		System.out.println("path = " + path);
		resp.sendRedirect(path);
	}
}
