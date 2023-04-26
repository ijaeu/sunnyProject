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
		
		QuestionReplyDAO questionReplyDAO = new QuestionReplyDAO();
		QuestionReplyVO questionReplyVO = new QuestionReplyVO();
		Gson gson = new Gson();
		JsonArray replies = new JsonArray();

		System.out.println("QuestionReplyListOkController 들어옴");

		// 넘어온 데이터 변수에 저장
		int questionNumber = Integer.valueOf(req.getParameter("questionNumber"));

		// 변수로 replyList 받아옴
		List<QuestionReplyVO> questionReplyList = questionReplyDAO.selectAll(questionNumber);
		
		// 리스트의 데이터를 gson에 저장
		for(QuestionReplyVO questionReply : questionReplyList) {
			String questionReplyJson = gson.toJson(questionReply);
			replies.add(JsonParser.parseString(questionReplyJson));
		}

		// gson으로 다시 페이지로 보냄
		resp.setContentType("application/json; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(replies.toString());
		// 꼭 닫아야함
		out.close();
	}

}
 