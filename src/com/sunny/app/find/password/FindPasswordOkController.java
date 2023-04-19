package com.sunny.app.find.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.find.password.dao.FindPasswordDAO;
import com.sunny.app.user.dto.UserDTO;
import com.sunny.app.user.vo.UserVO;

public class FindPasswordOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String userId = req.getParameter("userId");
        int findQuestionNumber = Integer.valueOf(req.getParameter("findQuestionNumber"));
        String findPasswordAnswer = req.getParameter("findPasswordAnswer");
        System.out.println(userId);
        System.out.println(findQuestionNumber);
        System.out.println(findPasswordAnswer);

        UserVO userVO = new UserVO();
        userVO.setUserId(userId);
        userVO.setFindQuestionNumber(findQuestionNumber);
        userVO.setFindPasswordAnswer(findPasswordAnswer);

        // 입력된 정보가 일치하는지 확인
        FindPasswordDAO findPasswordDAO = new FindPasswordDAO();
        int userNumber = findPasswordDAO.findPassword(userVO);
        System.out.println("userNumber = "+ userNumber);
        if (userNumber > 0) {
            // 일치하면 ResetPasswordController로 데이터 전송
            req.setAttribute("userNumber", userNumber);
            req.getRequestDispatcher("/find/resetPw.fp").forward(req, resp);
        } else {
        	// 불일치 시 alert 창 출력 후 현재 페이지에서 다시 입력할 수 있도록 함
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("<script>alert('일치하는 회원정보가 없습니다.');history.back();</script>");
        }
        
        System.out.println("FindPasswordOkController 진입");
		
	}
}
