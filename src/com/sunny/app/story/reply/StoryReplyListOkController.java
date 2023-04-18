package com.sunny.app.story.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sunny.app.Execute;
import com.sunny.app.story.reply.dao.StoryReplyDAO;
import com.sunny.app.story.reply.vo.StoryReplyVO;

public class StoryReplyListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int storyNumber = Integer.valueOf(req.getParameter("storyNumber"));
		StoryReplyDAO storyReplyDAO = new StoryReplyDAO();
		Gson gson = new Gson();
		JsonArray replies = new JsonArray();
		
		List<StoryReplyVO>storyReplyList  = storyReplyDAO.selectAll(storyNumber);
		
		for(StoryReplyVO storyReply : storyReplyList) {
			String storyReplyJson = gson.toJson(storyReply);
			
			System.out.println(storyReplyJson);
			
			replies.add(JsonParser.parseString(storyReplyJson));
		}
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(replies.toString());
		out.close();
		
	}

}
