package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.find.password.dto.FindPasswordDTO;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.user.dto.UserDTO;
import com.sunny.app.user.vo.UserVO;

public class JoinOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		UserVO userVO = new UserVO();
		FindPasswordDTO findPasswordDTO = new FindPasswordDTO();
		
//		<insert id="join" parameterType="MemberDTO">
//		insert into tbl_user(user_id, user_password, user_name, user_nickname, user_phone, user_email, user_date)
//		values(#{userId}, #{userPassword}, #{userName}, #{userNickname}, #{userPhone}, #{userEmail}, now())
//		</insert>
//		System.out.println(req.getParameter("userPhone"));
		
		req.setCharacterEncoding("utf-8");
		System.out.println(req.getParameter("userName"));
		userDTO.setUserId(req.getParameter("userId"));
		userDTO.setUserPassword(req.getParameter("userPassword"));
		userDTO.setUserName(req.getParameter("userName"));
		userDTO.setUserNickname(req.getParameter("userNickname"));
		userDTO.setUserPhone(req.getParameter("userPhone"));
		userDTO.setUserEmail(req.getParameter("userEmail"));
		userDTO.setUserDate(req.getParameter("userDate"));
		
		System.out.println(userDTO);
		userDAO.join(userDTO);
		
		int tmp = userDAO.login(userDTO);
		
		System.out.println("=========================================");
		System.out.println(tmp);
//		System.out.println(req.getParameter("userName"));
		
		
		
		
		findPasswordDTO.setUserNumber(tmp);
		
		
		System.out.println(req.getParameter("findQuestionNumber"));
		
		findPasswordDTO.setFindQuestionNumber(Integer.valueOf(req.getParameter("findQuestionNumber"))); 
		findPasswordDTO.setFindPasswordAnswer(req.getParameter("findPasswordAnswer")); 
		 
		

		
		// 가입했을때 시퀀스로 생성된 user_number를 가져와야함.
		


		userDAO.insertFindPassword(findPasswordDTO);
		
		System.out.println(userDTO);
		
		req.setAttribute("userId", userDTO.getUserId());
		
//		req.getRequestDispatcher("/app/user/joinOk.jsp").forward(req, resp);
		resp.sendRedirect("/user/result.us?userId="+userDTO.getUserId());
		
	}
}
