package com.sunny.app.user.file;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunny.app.Execute;
import com.sunny.app.user.file.dao.UserFileDAO;
import com.sunny.app.user.file.vo.UserFileVO;


public class UserFileDeleteController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("delete컨트롤러들어옴");
		UserFileDAO userFileDAO = new UserFileDAO();
		HttpSession session = req.getSession();
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		
		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "uploadProfile/";
		
		if(userFileDAO.select(userNumber)>0) {
			 UserFileVO userFileVO = userFileDAO.selectFile(userNumber);
        	 File existFile = new File(uploadPath, userFileVO.getFileSystemName());
        	 existFile.delete();
			
			userFileDAO.delete(userNumber);	
		}
		
		

	}

}
