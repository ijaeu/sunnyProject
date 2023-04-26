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
import com.sunny.app.question.file.dao.QuestionFileDAO;
import com.sunny.app.question.file.dto.QuestionFileDTO;
import com.sunny.app.util.UserUtils;

public class QuestionUpdateOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		QuestionDAO questionDAO = new QuestionDAO();
		QuestionFileDAO questionFileDAO = new QuestionFileDAO();
		QuestionFileDTO questionFileDTO = new QuestionFileDTO();

		System.out.println("QuestionUpdateOkController 들어옴");

		// 세션체크
		int userNumber = 0;
		if (UserUtils.sessionCheck(req) == 0) {
			resp.sendRedirect("/user/login.us?login=noInfo");
			return;
		} else {
			userNumber = UserUtils.sessionCheck(req);
		}

		
		// 파일 사이즈 , 업로드 경로 설정
		int maxSize = 1024 * 1024 * 30;
		String fsl = File.separator;
		String root = req.getSession().getServletContext().getRealPath(fsl);
		String rootPath = root + fsl + "upload/questionUpload";

		System.out.println(rootPath);

		MultipartRequest mr = new MultipartRequest(req, rootPath, maxSize, "utf-8", new DefaultFileRenamePolicy());


		// gosuNumber, questionNumber 확인
		// MultipartRequest 사용시 req에서 getParameter 사용 불가능
		// 그러므로 MultipartRequest에서 값을 받아와야 한다
		int gosuNumber = Integer.parseInt(mr.getParameter("gosuNumber"));
		int questionNumber = Integer.parseInt(mr.getParameter("questionNumber"));
		System.out.println("gosuNumber = " + gosuNumber);
		System.out.println("questionNumber = " + questionNumber);

		// 수정페이지에서 받아온 내용을 변수에 저장 
		String questionTitle = mr.getParameter("questionTitle");
		String questionContent = mr.getParameter("questionContent");

		// map에 저장해서 DAO -> 쿼리 실행
		Map<String, Object>pageMap = new HashMap<>();
		pageMap.put("questionTitle", questionTitle);
		pageMap.put("questionContent", questionContent);
		pageMap.put("questionNumber", questionNumber);
		questionDAO.update(pageMap);

		// 수정전 첨부 파일이름을 DB에서 조회후 로컬에서 삭제
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
		// DB에서도 삭제
		questionFileDAO.delete(questionNumber);

		// 새 첨부파일 파일이름 DB 저장
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
		
		// 페이지 이동
		resp.sendRedirect("/question/questionListOk.qs?gosuNumber=" + gosuNumber);
	}
}