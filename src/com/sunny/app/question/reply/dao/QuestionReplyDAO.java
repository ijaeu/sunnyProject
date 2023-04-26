package com.sunny.app.question.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.question.reply.dto.QuestionReplyDTO;
import com.sunny.app.question.reply.vo.QuestionReplyVO;

public class QuestionReplyDAO {
	
	public SqlSession sqlSession;
	
	public QuestionReplyDAO() {
		
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	댓글리스트 가져오기
	public List<QuestionReplyVO> selectAll(int questionNumber) {
		System.out.println("댓글 리스트 select 메서드");
		return sqlSession.selectList("questionReply.selectAll", questionNumber);
	}
	
//	댓글 입력
	public void insert(QuestionReplyDTO questionReplyDTO) {
		System.out.println("댓글 입력 메서드");
		sqlSession.insert("questionReply.insert", questionReplyDTO);
	}
	
//	댓글 삭제
	public void delete(int replyNumber) {
		System.out.println("댓글 삭제 메서드");
		sqlSession.delete("questionReply.delete", replyNumber);
	}
	
//	댓글 수정
	public void update(QuestionReplyDTO questionReplyDTO) {
		System.out.println("댓글 수정 메서드");
		sqlSession.update("questionReply.update", questionReplyDTO);
	}
}