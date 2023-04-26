package com.sunny.app.gosu.apply;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sunny.app.Execute;
import com.sunny.app.gosu.apply.dao.GosuApplyDAO;
import com.sunny.app.gosu.apply.dto.GosuApplyDTO;
import com.sunny.app.gosu.apply.file.dao.GosuApplyFileDAO;
import com.sunny.app.gosu.apply.file.dto.GosuApplyFileDTO;
import com.sunny.app.gosu.dao.GosuDAO;
import com.sunny.app.gosu.dto.GosuDTO;
import com.sunny.app.gosu.field.dao.GosuFieldDAO;
import com.sunny.app.gosu.field.dto.GosuFieldDTO;
import com.sunny.app.util.UserUtils;

public class gosuApplyWriteOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		GosuDAO gosuDAO = new GosuDAO();
		GosuDTO gosuDTO = new GosuDTO();
		GosuFieldDAO gosuFieldDAO = new GosuFieldDAO();
		GosuFieldDTO gosuFieldDTO = new GosuFieldDTO();
		GosuApplyDAO gosuApplyDAO = new GosuApplyDAO();
		GosuApplyDTO gosuApplyDTO = new GosuApplyDTO();
		GosuApplyFileDAO gosuApplyFileDAO = new GosuApplyFileDAO();
		GosuApplyFileDTO gosuApplyFileDTO = new GosuApplyFileDTO();
		
		// 세션체크
		int userNumber = 0;
		if (UserUtils.sessionCheck(req) == 0) {
			resp.sendRedirect("/user/login.us?login=noInfo");
			return;
		} else {
			userNumber = UserUtils.sessionCheck(req);
		}
		
		// 파일 사이즈 , 업로드 경로 설정
        int maxSize  = 1024*1024*30;
        String fsl = File.separator;
        String root = req.getSession().getServletContext().getRealPath(fsl);
        String rootPath = root + fsl + "upload/applyUpload";
		
		System.out.println(rootPath);

		MultipartRequest mr = new MultipartRequest(req, rootPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
		
		// 식고수 신청 게시글 작성 DB 저장
		
		gosuApplyDTO.setApplyTitle(mr.getParameter("applyTitle"));
		gosuApplyDTO.setApplyContent(mr.getParameter("applyContent"));
		gosuApplyDTO.setUserNumber(userNumber);
		gosuApplyDAO.insert(gosuApplyDTO);
		
		// applyNumber 가져오기
		
		int applyNumber = gosuApplyDAO.getSequence();
		
		System.out.println("applyNumber = " + applyNumber);
		
		// 식고수 신청 게시글 첨부파일 DB 저장
		
		Enumeration<String> fileNames = mr.getFileNames();
		
		int fileCount = 0;
		while (fileNames.hasMoreElements() && fileCount < 3) {
		    String name = fileNames.nextElement();
		    String fileSystemName = mr.getFilesystemName(name);
		    String fileOriginalName = mr.getOriginalFileName(name);
		    if (fileSystemName == null) {
		        continue;
		    }
		    gosuApplyFileDTO.setFileSystemName(fileSystemName);
		    gosuApplyFileDTO.setFileOriginalName(fileOriginalName);
		    gosuApplyFileDTO.setApplyNumber(applyNumber);
		    gosuApplyFileDAO.insert(gosuApplyFileDTO);
		    fileCount++;
		    System.out.println(fileCount);
		}
		
		// 식고수 데이터 DB 저장
		
		gosuDTO.setGosuPlan(mr.getParameter("applyContent"));
		gosuDTO.setUserNumber(userNumber);
		
		gosuDAO.insert(gosuDTO);
		
		//	gosuNumber 저장
		
		int gosuNumber = gosuDAO.getSequence();
		
		// 식고수 분야 데이터 DB 저장
		
		String[] fields = mr.getParameterValues("fields");
			for(String s : fields) {
				gosuFieldDTO.setFieldNumber(Integer.parseInt(s));
				gosuFieldDTO.setGosuNumber(gosuNumber);
				System.out.println("gosufield 데이터 저장 gosuNumber = " + gosuNumber + " / gosuFieldNumber = " + s);
				gosuFieldDAO.insert(gosuFieldDTO);
			}
			
		//	회원 상태 200 처리
			gosuApplyDAO.applying(userNumber);
			
		// 마이페이지로 이동 ( 모달 " 신청이 완료되었습니다 ") url로 보내기
			
			resp.sendRedirect("/user/myPage.us");	
		
		
	}

}
