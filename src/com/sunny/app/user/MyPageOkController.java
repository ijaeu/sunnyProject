package com.sunny.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.follow.dao.FollowDAO;
import com.sunny.app.follow.dto.FollowDTO;
import com.sunny.app.gosu.dao.GosuDAO;
import com.sunny.app.my.page.dto.MyPageDTO;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.story.file.vo.StoryFileVO;
import com.sunny.app.user.dao.UserDAO;
import com.sunny.app.user.file.dao.UserFileDAO;
import com.sunny.app.user.vo.UserVO;

public class MyPageOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("myPageOk컨트롤러진입");
		
		HttpSession session = req.getSession();
		UserDAO userDAO = new UserDAO();
		FollowDAO followDAO = new FollowDAO();
		UserFileDAO userFileDAO = new UserFileDAO();
		GosuDAO gosuDAO = new GosuDAO();
		QuestionDAO questionDAO = new QuestionDAO();
		
		StoryFileVO storyFileVO = new StoryFileVO();
		MyPageDTO myPageDTO = new MyPageDTO();
		UserVO userVO = new UserVO();
		FollowDTO followDTO = new FollowDTO();
		Integer userNumber = 0;
		Integer checkFollow =0;
		
//		req.getpa...userNumber==null이면 세션에서 받아와 아니면 파라미터에서받아와 -> userNumber에 저장해
		if(req.getParameter("userNumber")==null) {
			userNumber = (Integer) session.getAttribute("userNumber");
		}else {
			userNumber = Integer.parseInt(req.getParameter("userNumber"));
			
			int userTo = userNumber;
			int userFrom =0;
			if((Integer) session.getAttribute("userNumber") !=null) {
				userFrom = (Integer) session.getAttribute("userNumber");				
			}
			followDTO.setUserTo(userTo);
			followDTO.setUserFrom(userFrom);
			checkFollow = followDAO.checkFollow(followDTO);
		}
		req.setAttribute("checkFollow", checkFollow);
		System.out.println(userNumber);
		
		myPageDTO.setUserNumber(userNumber);
		
		userVO=userDAO.getUserInfo(userNumber);

		myPageDTO.setUserComment(userVO.getUserComment());
		myPageDTO.setGradeNumber(userVO.getGradeNumber());
		myPageDTO.setUserNickname(userVO.getUserNickname());
		
		System.out.println(userVO.getGradeNumber());
		
//		프로필사진이 없으면 userFile에 기본로고를 넣어준다. > c:choose로 처리
		myPageDTO.setUserFile(userFileDAO.selectFile(userNumber));
		myPageDTO.setFollowerCnt(followDAO.selectFollowerCnt(userNumber));
		myPageDTO.setFollowingCnt(followDAO.selectFollowingCnt(userNumber));
		
		System.out.println(followDAO.selectFollowingCnt(userNumber));
		
//		내가 쓴 스토리 리스트 받아오기
		System.out.println(userDAO.myStoryList(userNumber));
		
		try {
			myPageDTO.setStoryCnt(userDAO.myStoryCnt(userNumber));
			myPageDTO.setStoryFiles(userDAO.myStoryList(userNumber));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		이 밑으로는 myPageQuestionListController 에서 처리하는걸로 한다.
		if(userVO.getGradeNumber()==500) {
			int gosuNumber = gosuDAO.getGosuNumber(userNumber);
			myPageDTO.setGosuNumber(gosuNumber);
		}
		
		req.setAttribute("myPage", myPageDTO);
		
		req.getRequestDispatcher("/app/user/myPage.jsp").forward(req, resp);
		
	}

}
