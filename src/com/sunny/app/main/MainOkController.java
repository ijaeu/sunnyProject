package com.sunny.app.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.main.dao.MainDAO;
import com.sunny.app.main.dto.MainDTO;

public class MainOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("메인오케이컨트롤러 들어왔다");
		MainDAO mainDAO = new MainDAO();
		MainDTO mainDTO = new MainDTO();
		
//		고수 질문많은순 1명뽑아옴
		mainDTO.setGosu(mainDAO.selectGosuMain());
		
//		storyNumber, storyTitle, fileSystemName, userNickname, userProfileImage 가져와야함
		mainDTO.setStoryList(mainDAO.SelectMainStory());
		
		System.out.println(mainDTO);
		
		req.setAttribute("main", mainDTO);
		req.getRequestDispatcher("/app/main/main2.jsp").forward(req, resp);
	}

}
