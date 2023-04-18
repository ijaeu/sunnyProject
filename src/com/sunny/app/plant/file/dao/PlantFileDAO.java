package com.sunny.app.plant.file.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;

public class PlantFileDAO {

	
	public SqlSession sqlSession;
	
	public PlantFileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
}
