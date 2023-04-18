package com.sunny.app.story;

import java.io.IOException;
import java.util.Enumeration;

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

public class StoryWriteOkController implements Execute {

   @Override
   public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       StoryDAO storyDAO = new StoryDAO();
           StoryFileDAO storyFileDAO = new StoryFileDAO();
           int storyNumber = 0;

           System.out.println("storyOkContoller");

           String uploadPath = req.getSession().getServletContext().getRealPath("/") + "storyUpload/";
           int fileSize = 1024*1024*10;
           System.out.println(uploadPath);

           MultipartRequest multipartRequest = new MultipartRequest(req, uploadPath, fileSize,"utf-8",new DefaultFileRenamePolicy());

           StoryDTO storyDTO = new StoryDTO();
           storyDTO.setStoryTitle(multipartRequest.getParameter("storyTitle"));
           storyDTO.setStoryContent(multipartRequest.getParameter("storyContent"));
           storyDTO.setStoryContent2(multipartRequest.getParameter("storyContent2"));
           storyDTO.setStoryContent3(multipartRequest.getParameter("storyContent3"));
           storyDTO.setUserNumber((Integer)req.getSession().getAttribute("userNumber"));



           Enumeration<String> fileNames = multipartRequest.getFileNames();

           while(true) {
               String name = fileNames.nextElement();

               String fileSystemName = multipartRequest.getFilesystemName("storyFile");
               String fileOriginalName = multipartRequest.getOriginalFileName("storyFile");
               storyDTO.setStoryNumber(storyNumber);
               storyDTO.setFileSystemName(fileSystemName);
               storyDTO.setFileOriginalName(fileOriginalName);
               storyDAO.insert(storyDTO);
               break;
           }
           storyDAO.updateCover(storyDTO);

           storyNumber = storyDAO.getSequence();
           System.out.println(storyNumber);

           // 파일 저장은 됨.
           fileNames = multipartRequest.getFileNames(); // 파일 정보를 다시 가져옴

           while(true) {
               String name = fileNames.nextElement();

               String fileSystemName1 = multipartRequest.getFilesystemName("file2");
               String fileOriginalName1 = multipartRequest.getOriginalFileName("file2");
               String fileSystemName2 = multipartRequest.getFilesystemName("file3");
               String fileOriginalName2 = multipartRequest.getOriginalFileName("file3");
               String fileSystemName3 = multipartRequest.getFilesystemName("file4");
               String fileOriginalName3 = multipartRequest.getOriginalFileName("file4");

               if(fileSystemName1 == null) {continue;}

               StoryFileDTO storyFileDTO = new StoryFileDTO();
               storyFileDTO.setStoryNumber(storyNumber);
               storyFileDTO.setFileSystemName1(fileSystemName1);
               storyFileDTO.setFileOriginalName1(fileOriginalName1);
               storyFileDTO.setFileSystemName2(fileSystemName2);
               storyFileDTO.setFileOriginalName2(fileOriginalName2);
               storyFileDTO.setFileSystemName3(fileSystemName3);
               storyFileDTO.setFileOriginalName3(fileOriginalName3);

               
               
//               if(fileSystemName2 != null && !fileSystemName2.equals("")) {
//               }
//
//               if(fileSystemName3 != null && !fileSystemName3.equals("")) {
//               }

               storyFileDAO.insert(storyFileDTO); // 파일 정보를 DB에 저장
               break;
   }
   
   
   resp.sendRedirect("/story/storyListOk.st");
   }
}