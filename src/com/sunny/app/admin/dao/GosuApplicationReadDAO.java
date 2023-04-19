package com.sunny.app.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.admin.vo.GosuApplicationReadVO;
import com.sunny.app.gosu.apply.file.dto.GosuApplyFileDTO;

public class GosuApplicationReadDAO {
	
	public SqlSession sqlSession;
	
	public GosuApplicationReadDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public GosuApplicationReadVO applyRead(int applyNumber) {
		System.out.println("applyRead 메서드");
		return sqlSession.selectOne("admin.applicationRead", applyNumber);
	}
	
	public List<GosuApplyFileDTO> readApplyFile(int applyNumber) {
		return sqlSession.selectList("admin.readApplyFile", applyNumber);
	}
}
