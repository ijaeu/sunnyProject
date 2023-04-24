package com.sunny.app.algorithm.dao;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.algorithm.dto.AlgorithmDTO;
import com.sunny.app.plant.dto.PlantDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlgorithmDAO {
	private SqlSession sqlSession;

	public AlgorithmDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public PlantDTO algorithmResult(AlgorithmDTO algorithmDTO) {
	    return sqlSession.selectOne("algorithmResult", algorithmDTO);
	}
	
	
}