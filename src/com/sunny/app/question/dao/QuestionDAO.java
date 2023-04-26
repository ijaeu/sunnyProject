package com.sunny.app.question.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.question.dto.QuestionDTO;
import com.sunny.app.question.vo.GosuInfoVO;
import com.sunny.app.question.vo.QuestionListVO;
import com.sunny.app.question.vo.QuestionReadVO;
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
	
//	questionNumber 가져오기
	public int getSequence() {
		System.out.println("questionNumber가져오기");
		return sqlSession.selectOne("question.getSequence");
	}
	
//  고수 닉네임 뽑기
	public String getNickName(int gosuNumber2) {
		return sqlSession.selectOne("question.getNickName", gosuNumber2);
	}
	
//	질문 조회수
	public void updateReadCount (int questionNumber) {
		System.out.println("조회수 +1 메서드");
		sqlSession.update("question.updateReadCount", questionNumber);
	}
	
//	나에게온 질문리스트 뽑기
	public List<QuestionVO> getMypageList(Map<String, Integer> gosuQ) {
		return sqlSession.selectList("question.getMypageList", gosuQ);
	}
	
//	질문 리스트 페이지 질문 목록
	public List<QuestionListVO> getQuestionList(Map<String, Integer> questionMap){
		System.out.println("질문 목록 selectList 메서드");
		return sqlSession.selectList("question.questionList", questionMap);
	}
	
//	질문 리스트 페이지 고수 정보 
	public GosuInfoVO gosuInfo(int gosuNumber) {
		System.out.println("고수 정보 select 메서드");
		return sqlSession.selectOne("question.gosuInfo", gosuNumber);
	}
	
//	Read페이지 게시글 데이터
	public QuestionReadVO questionRead(Map<String, Integer> map) {
		System.out.println("질문 select 메서드 ");
		return sqlSession.selectOne("question.questionRead", map);
	}
	
//	질문 삭제
	public void delete(int questionNumber) {
		System.out.println("질문 삭제 메서드");
		sqlSession.delete("question.delete", questionNumber);
	}
	
//	수정 정보 가져오기
	public QuestionDTO updateSelect(int questionNumber) {
		System.out.println("수정할 질문데이터 select 메서드");
		return sqlSession.selectOne("question.updateSelect", questionNumber);
	}
	
//	수정
	public void update(Map<String, Object> pageMap) {
		System.out.println("질문 수정 update 메서드");
		sqlSession.update("question.update", pageMap);
	}
	
//  게시글 상태체크
	public int updateQuestionStatus(Map<String, Integer> map) {
		System.out.println("고수답변확인 + update 메서드");
		return sqlSession.update("question.updateQuestionStatus", map);
	}
}




















