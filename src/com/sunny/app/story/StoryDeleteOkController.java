package com.sunny.app.story;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.story.dao.StoryDAO;
import com.sunny.app.story.file.dao.StoryFileDAO;
import com.sunny.app.story.file.dto.StoryFileDTO;

public class StoryDeleteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StoryDAO storyDAO = new StoryDAO();
		StoryFileDAO storyFileDAO = new StoryFileDAO();
		
		int storyNumber = Integer.valueOf(req.getParameter("storyNumber"));
		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "storyUpload";
		List<StoryFileDTO> storyFiles = storyFileDAO.select(storyNumber);
		
		for(StoryFileDTO file : storyFiles) {
		    String fileName1 = file.getFileSystemName1();
		    String fileName2 = file.getFileSystemName2();
		    String fileName3 = file.getFileSystemName3();
		    
		    if (fileName1 != null) {
		        File temp1 = new File(uploadPath, fileName1);
		        if(temp1.exists()) {
		            temp1.delete();
		        }
		    }
		    if (fileName2 != null) {
		        File temp2 = new File(uploadPath, fileName2);
		        if(temp2.exists()) {
		            temp2.delete();
		        }
		    }
		    if (fileName3 != null) {
		        File temp3 = new File(uploadPath, fileName3);
		        if(temp3.exists()) {
		            temp3.delete();
		        }
		    }
		}
		
		storyFileDAO.delete(storyNumber);
		storyDAO.delete(storyNumber);
		
		resp.sendRedirect("/story/storyListOk.st");
	}

}
