package com.sunny.app.question.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.question.dto.QuestionDTO;
import com.sunny.app.question.vo.GosuInfoVO;
import com.sunny.app.question.vo.QuestionListVO;
import com.sunny.app.question.vo.QuestionVO;

public class QuestionDAO {

	
	public SqlSession sqlSession;
	
	
	public QuestionDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	리스트 뽑는거 
	public List<QuestionDTO> selectAll (Map<String, Integer> pageMap) {
		return sqlSession.selectList("question.selectAll", pageMap);
	}
	
//  페이징처리
	public int getTotal() {
		return sqlSession.selectOne("question.getTotal");
	}
	
//	질문쓰기 
	public void insert(QuestionDTO questionDTO) {
		sqlSession.insert("question.insert", questionDTO);
	}
	
	public int getSequence() {
		return sqlSession.selectOne("question.getSequence");
	}
	
//  고수 닉네임 뽑기
	public String getNickName(int gosuNumber2) {
		return sqlSession.selectOne("question.getNickName", gosuNumber2);
	}
	
//	질문 읽기 
	public QuestionVO select(int questionNumber) {
		return sqlSession.selectOne("question.select", questionNumber);
	}
	
//	질문 조회수
	public void updateReadCount (int questionNumber) {
		sqlSession.update("question.updateReadCount", questionNumber);
	}
	
//	나에게온 질문리스트 뽑기
	public List<QuestionVO> getMypageList(Map<String, Integer> gosuQ) {
		return sqlSession.selectList("question.getMypageList", gosuQ);
	}
	
//	질문리스트 페이지
	public List<QuestionListVO> getQuestionList(Map<String, Integer> questionMap){
		System.out.println("getQuestionList 메서드");
		return sqlSession.selectList("question.questionList", questionMap);
	}
	
//	고수 정보뽑기
	public GosuInfoVO gosuInfo(int gosuNumber) {
		System.out.println("gosuInfo 메서드");
		return sqlSession.selectOne("question.gosuInfo", gosuNumber);
	}
}




















