package com.sunny.app.gosu.field.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.gosu.field.dto.GosuFieldDTO;

public class GosuFieldDAO {

	
	public SqlSession sqlSession;
	
	
	public GosuFieldDAO() {
		
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(GosuFieldDTO gosuFieldDTO) {
		sqlSession.insert("gosuField.insert", gosuFieldDTO);
	}
}
