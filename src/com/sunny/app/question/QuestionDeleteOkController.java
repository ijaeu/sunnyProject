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
		
		QuestionDAO questionDAO = new QuestionDAO();
		QuestionFileDAO questionFileDAO = new QuestionFileDAO();
		
		System.out.println("QuestionDeleteOkController 들어옴");
		
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		int gosuNumber = Integer.valueOf(req.getParameter("gosuNumber"));
		
		// 경로 확인
		String fsl = File.separator;
		String root = req.getSession().getServletContext().getRealPath(fsl);
		String rootPath = root + fsl + "upload/questionUpload";
		
		// DB의 파일이름 확인후 경로에서 파일 지우기
		QuestionFileDTO questionFile = questionFileDAO.select(questionNumber);
		String fileName = "";
		if (questionFile != null) {
			fileName = questionFile.getFileSystemName();
			if (fileName != null) {
				File temp1 = new File(rootPath, fileName);
				if (temp1.exists()) {
					temp1.delete();
				}
			}
		}
	    
		// 파일삭제
	    questionFileDAO.delete(questionNumber);
	    // 게시글 삭제
	    questionDAO.delete(questionNumber);
	    
	    // 페이지 이동
	    resp.sendRedirect("/question/questionListOk.qs?gosuNumber=" + gosuNumber);
	     
	}

}
