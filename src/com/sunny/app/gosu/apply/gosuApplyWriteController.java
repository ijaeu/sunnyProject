package com.sunny.app.gosu.apply;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.field.dao.FieldDAO;
import com.sunny.app.field.dto.FieldDTO;

public class gosuApplyWriteController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		String path = null;
		
		//	session에 userNumber 확인 후 없으면 로그인 페이지 경로처리하기
		if(userNumber == null) {
			path = "/app/user/login.jsp";
		}else {
		//	field List 불러오기 
			FieldDAO fieldDAO = new FieldDAO();
			path = "/app/apply/gosuApplyWrite.jsp";
			Map<String, Integer> pageMap = new HashMap<>();
			List<FieldDTO> fieldList = fieldDAO.fieldList(pageMap);
			
			req.setAttribute("fieldList", fieldList);
		}
		req.getRequestDispatcher(path).forward(req, resp);
	}
}
