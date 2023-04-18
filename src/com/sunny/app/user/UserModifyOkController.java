package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.user.vo.UserVO;

public class UserModifyOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDAO userDAO = new UserDAO();
		UserVO userVO = new UserVO();
		
		req.setCharacterEncoding("utf-8");
		
		userVO.setUserNumber((Integer)session.getAttribute("userNumber"));
		userVO.setUserPassword(req.getParameter("userPassword"));
		userVO.setUserNickname(req.getParameter("userNickname"));
		userVO.setUserEmail(req.getParameter("userEmail"));
		userVO.setUserPhone(req.getParameter("userPhone"));
		userVO.setFindQuestionNumber(Integer.valueOf(req.getParameter("findQuestionNumber")));
		userVO.setFindPasswordAnswer(req.getParameter("findPasswordAnswer"));
		
		userDAO.userModify(userVO);
		
		

	}

}
