package com.sunny.app.story;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sunny.app.Execute;
import com.sunny.app.story.dao.StoryDAO;
import com.sunny.app.story.dto.StoryDTO;
import com.sunny.app.story.file.dao.StoryFileDAO;
import com.sunny.app.story.file.dto.StoryFileDTO;

public class StoryUpdateOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("storyupdateOkController");
		StoryDAO storyDAO = new StoryDAO();
		StoryFileDAO storyFileDAO = new StoryFileDAO();
		
		System.out.println("storyOkContoller");

		String uploadPath = req.getSession().getServletContext().getRealPath("/") + "storyUpload/";
		int fileSize = 1024 * 1024 * 10;
		System.out.println(uploadPath);

		MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize, "utf-8",
				new DefaultFileRenamePolicy());

		int storyNumber = Integer.parseInt(multipartRequest.getParameter("storyNumber"));
		StoryDTO storyDTO = new StoryDTO();
		storyDTO.setStoryTitle(multipartRequest.getParameter("storyTitle"));
		storyDTO.setStoryContent(multipartRequest.getParameter("storyContent"));
		storyDTO.setStoryContent2(multipartRequest.getParameter("storyContent2"));
		storyDTO.setStoryContent3(multipartRequest.getParameter("storyContent3"));
		storyDTO.setUserNumber((Integer) req.getSession().getAttribute("userNumber"));
		System.out.println("storynumber = " + storyNumber);
		storyFileDAO.delete(storyNumber);

		Enumeration<String> fileNames = multipartRequest.getFileNames();

		while (true) {
			String name = fileNames.nextElement();

			String fileSystemName = multipartRequest.getFilesystemName("storyFile");
			String fileOriginalName = multipartRequest.getOriginalFileName("storyFile");
			storyDTO.setStoryNumber(storyNumber);
			storyDTO.setFileSystemName(fileSystemName);
			storyDTO.setFileOriginalName(fileOriginalName);
			storyDAO.update(storyDTO);
			break;
		}
		storyDAO.updateCover(storyDTO);

		System.out.println(storyNumber);
		
		List<StoryFileDTO> storyFiles = storyFileDAO.select(storyNumber);

		for (StoryFileDTO file : storyFiles) {
			String fileName1 = file.getFileSystemName1();
			String fileName2 = file.getFileSystemName2();
			String fileName3 = file.getFileSystemName3();

			if (fileName1 != null) {
				File temp1 = new File(uploadPath, fileName1);
				if (temp1.exists()) {
					temp1.delete();
				}
			}
			if (fileName2 != null) {
				File temp2 = new File(uploadPath, fileName2);
				if (temp2.exists()) {
					temp2.delete();
				}
			}
			if (fileName3 != null) {
				File temp3 = new File(uploadPath, fileName3);
				if (temp3.exists()) {
					temp3.delete();
				}
			}
			
		}

		// 파일 저장은 됨.
		fileNames = multipartRequest.getFileNames(); // 파일 정보를 다시 가져옴

		while (true) {
			String name = fileNames.nextElement();

			String fileSystemName1 = multipartRequest.getFilesystemName("file2");
			String fileOriginalName1 = multipartRequest.getOriginalFileName("file2");
			String fileSystemName2 = multipartRequest.getFilesystemName("file3");
			String fileOriginalName2 = multipartRequest.getOriginalFileName("file3");
			String fileSystemName3 = multipartRequest.getFilesystemName("file4");
			String fileOriginalName3 = multipartRequest.getOriginalFileName("file4");

			if (fileSystemName1 == null) {
				continue;
			}

			StoryFileDTO storyFileDTO = new StoryFileDTO();
			storyFileDTO.setStoryNumber(storyNumber);
			storyFileDTO.setFileSystemName1(fileSystemName1);
			storyFileDTO.setFileOriginalName1(fileOriginalName1);
			storyFileDTO.setFileSystemName2(fileSystemName2);
			storyFileDTO.setFileOriginalName2(fileOriginalName2);
			storyFileDTO.setFileSystemName3(fileSystemName3);
			storyFileDTO.setFileOriginalName3(fileOriginalName3);


			storyFileDAO.insert(storyFileDTO); // 파일 정보를 DB에 저장
			break;

		}
		

		resp.sendRedirect("/story/storyListOk.st");
	}

}
