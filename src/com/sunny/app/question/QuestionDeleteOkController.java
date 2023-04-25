package com.sunny.app.question;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.file.dao.QuestionFileDAO;
import com.sunny.app.question.file.dto.QuestionFileDTO;

public class QuestionDeleteOkController implements Execute{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("QuestionDeleteOkController 들어옴");
		
		QuestionDAO questionDAO = new QuestionDAO();
		QuestionFileDAO questionFileDAO = new QuestionFileDAO();
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "questionUpload";
		
		QuestionFileDTO questionFile = questionFileDAO.select(questionNumber);
		String fileName = questionFile.getFileSystemName();
		
	    if (fileName != null) {
	        File temp1 = new File(uploadPath, fileName);
	        if(temp1.exists()) {
	            temp1.delete();
	        }
	    }
	    
	    questionFileDAO.delete(questionNumber);
	    questionDAO.delete(questionNumber);
	    
	    resp.sendRedirect("/question/questionListOk.qu");
	    
	}

}
