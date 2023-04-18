package com.sunny.app.user.file;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sunny.app.Execute;
import com.sunny.app.user.file.dao.UserFileDAO;
import com.sunny.app.user.file.dto.UserFileDTO;
import com.sunny.app.user.file.vo.UserFileVO;
import com.sunny.app.user.vo.UserVO;

public class UserFileOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("프로필사진등록 컨트롤러 들어옴!");

		UserFileDTO userFileDTO = new UserFileDTO();
		UserFileDAO userFileDAO = new UserFileDAO();
		HttpSession session = req.getSession();
		Integer userNumber = (Integer)session.getAttribute("userNumber");
		
		
	      String uploadPath = req.getSession().getServletContext().getRealPath("/") + "uploadProfile/";
	      int fileSize = 1024 * 1024 * 5; //5MB
	      System.out.println(uploadPath);
	      
	      MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "utf-8", new DefaultFileRenamePolicy());
	      
	      userFileDTO.setUserNumber(userNumber);

	      Enumeration<String> fileNames = multipartRequest.getFileNames();
	      while(fileNames.hasMoreElements()) {
	         String name = fileNames.nextElement();
	         
	         String fileSystemName = multipartRequest.getFilesystemName(name);
	         String fileOriginalName = multipartRequest.getOriginalFileName(name);
	         
	         if(fileSystemName == null) {continue;}
	         
	         userFileDTO.setFileSystemName(fileSystemName);
	         userFileDTO.setFileOriginalName(fileOriginalName);
	         
//	         업데이트 하는경우 실제 파일경로에서 원래있던 사진 지움
	         if(userFileDAO.select(userNumber)>0) {
	        	 
	        	 UserFileVO userFileVO = userFileDAO.selectFile(userNumber);
	        	 File existFile = new File(uploadPath, userFileVO.getFileSystemName());
	        	 existFile.delete();
	        	 
	        	 userFileDAO.update(userFileDTO);
	         }else {
	 			userFileDAO.insert(userFileDTO);
	 		}
		    
	      }
	      
//	      resp.sendRedirect("/board/boardListOk.bo");
	}

}
