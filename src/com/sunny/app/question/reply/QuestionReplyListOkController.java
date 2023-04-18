package com.sunny.app.question.reply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
import com.sunny.app.Execute;
import com.sunny.app.question.reply.dao.QuestionReplyDAO;
import com.sunny.app.question.reply.vo.QuestionReplyVO;


public class QuestionReplyListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("댓글들어왔다");

		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));
		QuestionReplyDAO questionReplyDAO = new QuestionReplyDAO();
		QuestionReplyVO questionReplyVO = new QuestionReplyVO();
		Gson gson = new Gson();
		JsonArray replies = new JsonArray();
		
		List<QuestionReplyVO> questionReplyList = questionReplyDAO.selectAll(questionNumber);
		
		for(QuestionReplyVO questionReply : questionReplyList) {
			String replyJson = gson.toJson(questionReply);
			
			System.out.println(replyJson);
			
//			replies.add(JsonParser.parseString(replyJson));
		}
		
		PrintWriter out = resp.getWriter();
		out.print(replies);
		out.close();
	}

}
