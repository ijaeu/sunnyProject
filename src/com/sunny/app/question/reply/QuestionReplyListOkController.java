package com.sunny.app.question.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;
import com.sunny.app.Execute;
import com.sunny.app.question.reply.dao.QuestionReplyDAO;
import com.sunny.app.question.reply.vo.QuestionReplyVO;


public class QuestionReplyListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("QuestionReplyListOkController");

		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		System.out.println("questionNumber = " + questionNumber);
		System.out.println("===================");
		QuestionReplyDAO questionReplyDAO = new QuestionReplyDAO();
		QuestionReplyVO questionReplyVO = new QuestionReplyVO();
		Gson gson = new Gson();
		JsonArray replies = new JsonArray();
		
		List<QuestionReplyVO> questionReplyList = questionReplyDAO.selectAll(questionNumber);
		
		for(QuestionReplyVO questionReply : questionReplyList) {
			String questionReplyJson = gson.toJson(questionReply);
			
			System.out.println("questionReplyJson : " + questionReplyJson);
			
			
			replies.add(JsonParser.parseString(questionReplyJson));
		}
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(replies.toString());
		out.close();
	}

}
 