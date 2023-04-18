package com.sunny.app.follow;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.follow.dao.FollowDAO;
import com.sunny.app.follow.dto.FollowDTO;

public class FollowInsertOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FollowDAO followDAO = new FollowDAO();
		FollowDTO followDTO = new FollowDTO();
		
		HttpSession session = req.getSession();
		Integer userNumber = (Integer) session.getAttribute("userNumber");

		followDTO.setUserFrom(userNumber);
		followDTO.setUserTo(Integer.parseInt(req.getParameter("userNumber")));
		
		followDAO.insert(followDTO);
	}

}
