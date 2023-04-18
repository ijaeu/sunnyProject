package com.sunny.app.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.admin.vo.GosuApplicationVO;

public class GosuApplicationListDAO {
	
	public SqlSession sqlSession;
	
	public GosuApplicationListDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public List<GosuApplicationVO> applicationList(Map<String, Integer> pageMap){
		System.out.println("applicationList 메서드");
		return sqlSession.selectList("admin.applicationList", pageMap);
	}
}
