package com.sunny.app.follow;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.follow.dao.FollowDAO;
import com.sunny.app.follow.vo.FollowVO;

public class FollowerListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("팔로워리스트Controller");
		FollowDAO followDAO = new FollowDAO();
//		내가 내 페이지에서 들어가는 경우 session에 있는 userNumber를 사용한다.
//		다른 사람의 페이지에서 follow로 들어가는 경우 그 사람의 userNumber를 사용한다.
		
		HttpSession session = req.getSession();
		Integer userNumber = 0;
		
		if(req.getParameter("userNumber")==null) {
			userNumber = (Integer) session.getAttribute("userNumber");
		}else {
			userNumber = Integer.parseInt(req.getParameter("userNumber"));
		}
		
		Map<String, Integer>number = new HashMap<String, Integer>();
		int myNumber = 0;
		if((Integer)session.getAttribute("userNumber")!=null) {
			myNumber = (Integer)session.getAttribute("userNumber");
		}
		number.put("myNumber", myNumber);
		number.put("userNumber", userNumber);
		
		List<FollowVO> followList = followDAO.selectFollower(number);
		
		req.setAttribute("followList", followList);
		req.setAttribute("userNumber", userNumber);
		req.getRequestDispatcher("/app/follow/follow.jsp").forward(req, resp);
		

	}

}
