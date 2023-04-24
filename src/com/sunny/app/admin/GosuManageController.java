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
import com.sunny.app.admin.dao.GosuManageDAO;
import com.sunny.app.admin.dto.AdminDTO;
import com.sunny.app.admin.vo.GosuManageVO;
import com.sunny.app.admin.vo.HeaderInfoVO;
import com.sunny.app.util.AdminUtils;

public class GosuManageController implements Execute {
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
		
		
		String searchWord = req.getParameter("searchWord");
		
		GosuManageDAO gosuManageDAO = new GosuManageDAO();
		HeaderInfoVO headerinfoVO = adminDAO.headerInfo();
		

		// 고수 회원 정보 불러오기
		Map<String, Object> pageMap = new HashMap<>();
				
		pageMap.put("searchWord", searchWord); 
		List<GosuManageVO> gosu = gosuManageDAO.gosuInfo(pageMap);

		// 데이터 세팅
		req.setAttribute("adminInfo", adminDTO);
		req.setAttribute("headerInfo", headerinfoVO);
		req.setAttribute("gosuList", gosu);
		
		// 페이지 이동
		req.getRequestDispatcher("/app/admin/gosuManage.jsp").forward(req, resp);
		

	}
}
