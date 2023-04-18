package com.sunny.app.find.password.question.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;

public class FindPasswordQuestionDAO {

	
	public SqlSession sqlSession;
	
	
	public FindPasswordQuestionDAO() {
		
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
}
