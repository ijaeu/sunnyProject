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
import com.sunny.app.admin.vo.GosuManageVO;
import com.sunny.app.admin.vo.HeaderInfoVO;
import com.sunny.app.util.AdminUtils;

public class GosuManageController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String searchWord = req.getParameter("searchWord");
		
		AdminDAO adminDAO = new AdminDAO();
		GosuManageDAO gosuManageDAO = new GosuManageDAO();
		HeaderInfoVO headerinfoVO = adminDAO.headerInfo();
		
		int adminNumber = 0;
		
		// 세션체크
		if (AdminUtils.sessionCheck(req)==0) {
			resp.sendRedirect("app/admin/login.ad?login=noInfo");
		} else {
			adminNumber = AdminUtils.sessionCheck(req);
		}
		
		System.out.println("adminNumber = " + adminNumber);

		// 고수 회원 정보 불러오기
		Map<String, Object> pageMap = new HashMap<>();
				
		pageMap.put("searchWord", searchWord); 
		List<GosuManageVO> gosu = gosuManageDAO.gosuInfo(pageMap);

		req.setAttribute("headerInfo", headerinfoVO);
		req.setAttribute("gosuList", gosu);
		req.getRequestDispatcher("/app/admin/gosuManage.jsp").forward(req, resp);
		
//		// 전체 회원 정보 가져오기
//
//		// 페이지 이동

	}
}
