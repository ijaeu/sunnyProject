package com.sunny.app.gosu.apply;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.field.dao.FieldDAO;
import com.sunny.app.field.dto.FieldDTO;
import com.sunny.app.util.UserUtils;

public class gosuApplyWriteController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 세션체크
		int userNumber = 0;
		if (UserUtils.sessionCheck(req) == 0) {
			resp.sendRedirect("/user/login.us?login=noInfo");
			return;
		} else {
			userNumber = UserUtils.sessionCheck(req);
		}

		FieldDAO fieldDAO = new FieldDAO();
		List<FieldDTO> fieldList = fieldDAO.fieldList();
			
		req.setAttribute("fieldList", fieldList);
		
		req.getRequestDispatcher("/app/apply/gosuApplyWrite.jsp").forward(req, resp);
	}
}
