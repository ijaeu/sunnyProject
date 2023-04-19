package com.sunny.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.admin.dao.AdminDAO;
import com.sunny.app.admin.dao.GosuApplicationReadDAO;
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.admin.vo.GosuApplicationReadVO;
import com.sunny.app.gosu.apply.file.dto.GosuApplyFileDTO;
import com.sunny.app.util.AdminUtils;

public class GosuApplicationBoardReadController implements Execute{
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
		//
		int applyNumber = Integer.parseInt(req.getParameter("applyNumber"));
		System.out.println("applyNumber = " + applyNumber);
		
		// apply 정보 가져오기
		GosuApplicationReadDAO gosuApplicationReadDAO = new GosuApplicationReadDAO();
		GosuApplicationReadVO gosuApplicationReadVO = gosuApplicationReadDAO.applyRead(applyNumber);
		List<GosuApplyFileDTO> files = new GosuApplicationReadDAO().readApplyFile(applyNumber);
		gosuApplicationReadVO.setFiles(files);
		
		// 데이터 세팅
		req.setAttribute("adminInfo", adminDTO);
		req.setAttribute("applydata", gosuApplicationReadVO);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/admin/gosuApplicationBoardRead.jsp").forward(req, resp);
	}

}
