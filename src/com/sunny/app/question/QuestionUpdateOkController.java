package com.sunny.app.question;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sunny.app.Execute;
import com.sunny.app.question.dao.QuestionDAO;
import com.sunny.app.question.dto.QuestionDTO;
import com.sunny.app.question.file.dao.QuestionFileDAO;
import com.sunny.app.question.file.dto.QuestionFileDTO;

public class QuestionUpdateOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		QuestionDAO questionDAO = new QuestionDAO();
		QuestionDTO questionDTO = new QuestionDTO();
		QuestionFileDAO questionFileDAO = new QuestionFileDAO();
		QuestionFileDTO questionFileDTO = new QuestionFileDTO();

		// 세션체크

		int userNumber = (Integer) req.getSession().getAttribute("userNumber");
		System.out.println("Session : userNumber = " + userNumber);

		
		// 파일 사이즈 , 업로드 경로 설정

		int maxSize = 1024 * 1024 * 30;
		String fsl = File.separator;
		String root = req.getSession().getServletContext().getRealPath(fsl);
		String rootPath = root + fsl + "upload/questionUpload";

		System.out.println(rootPath);

		MultipartRequest mr = new MultipartRequest(req, rootPath, maxSize, "utf-8", new DefaultFileRenamePolicy());


		// gosuNumber 확인

		int gosuNumber = Integer.parseInt(mr.getParameter("gosuNumber"));
		int questionNumber = Integer.parseInt(mr.getParameter("questionNumber"));
		System.out.println("gosuNumber = " + gosuNumber);
		System.out.println("questionNumber = " + questionNumber);

		// question 게시글 DB 저장
		
		Map<String, Object>pageMap = new HashMap<>();
		String questionTitle = mr.getParameter("questionTitle");
		String questionContent = mr.getParameter("questionContent");
		System.out.println(questionTitle + questionContent);
				
		pageMap.put("questionTitle", questionTitle);
		pageMap.put("questionContent", questionContent);
		pageMap.put("questionNumber", questionNumber);
		
		
		questionDAO.update(pageMap);
		System.out.println("question content update 완료 !");
		
		// 파일 삭제
		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "questionUpload";

		QuestionFileDTO questionFile = questionFileDAO.select(questionNumber);
		String fileName = "";
		if (questionFile != null) {
			fileName = questionFile.getFileSystemName();
			if (fileName != null) {
				File temp1 = new File(uploadPath, fileName);
				if (temp1.exists()) {
					temp1.delete();
				}

			}
		}

		// 첨부파일 파일 이름 DB 저장

		Enumeration<String> fileNames = mr.getFileNames();

		while (fileNames.hasMoreElements()) {
			String name = fileNames.nextElement();
			String fileSystemName = mr.getFilesystemName(name);
			String fileOriginalName = mr.getOriginalFileName(name);
			if (fileSystemName == null) {
				continue;
			}
			questionFileDTO.setFileSystemName(fileSystemName);
			questionFileDTO.setFileOriginalName(fileOriginalName);
			questionFileDTO.setQuestionNumber(questionNumber);
			questionFileDTO.setGosuNumber(gosuNumber);

			questionFileDAO.insert(questionFileDTO);
		}

		// 경로처리

		resp.sendRedirect("/question/questionListOk.qs?gosuNumber=" + gosuNumber);
	}

}
