package com.sunny.app.grade.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;

public class GradeDAO {

	
	public SqlSession sqlSession;
	
	
	public GradeDAO() {
		
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
}
