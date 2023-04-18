package com.sunny.app.field.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.field.dto.FieldDTO;

public class FieldDAO {

	
	public SqlSession sqlSession;
	
	
	public FieldDAO() {
		
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public List<FieldDTO> fieldList(Map<String, Integer> pageMap){
		System.out.println("field.select 메서드");
		return sqlSession.selectList("field.list", pageMap);
	 }
	
}
