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
		String userId = req.getParameter("userId");
        int findQuestionNumber = Integer.parseInt(req.getParameter("findQuestionNumber"));
        String findPasswordAnswer = req.getParameter("findPasswordAnswer");

        UserVO userVO = new UserVO();
        userVO.setUserId(userId);
        userVO.setFindQuestionNumber(findQuestionNumber);
        userVO.setFindPasswordAnswer(findPasswordAnswer);

        // 입력된 정보가 일치하는지 확인
        FindPasswordDAO findPasswordDAO = new FindPasswordDAO();
        int userNumber = findPasswordDAO.findPassword(userVO);
        if (userNumber > 0) {
            // 일치하면 ResetPasswordController로 데이터 전송
            req.setAttribute("userNumber", userNumber);
            req.getRequestDispatcher("/find/resetPwOk.fp").forward(req, resp);
        } else {
            // 불일치 시 오류 페이지 출력
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "입력된 정보가 일치하지 않습니다.");
        }
        
        System.out.println("FindPasswordOkController 진입");
		
	}
}
