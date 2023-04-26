package com.sunny.app.question.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.question.file.dto.QuestionFileDTO;

public class QuestionFileDAO {

	public SqlSession sqlSession;
	
	
	public QuestionFileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(QuestionFileDTO questionFileDTO) {
		sqlSession.insert("questionFile.insert", questionFileDTO);
	}
	
	public QuestionFileDTO select(int questionNumber) {
		return sqlSession.selectOne("questionFile.select", questionNumber);
	}
	
	public void delete(int questionNumber) {
		System.out.println("questionfile delete 메소드");
		System.out.println("questionNumber = " + questionNumber);
		sqlSession.delete("questionFile.delete", questionNumber);
	}
}
