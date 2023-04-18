package com.sunny.app.gosu.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.gosu.vo.GosuVO;
import com.sunny.app.gosu.dto.GosuDTO;
import com.sunny.app.user.vo.UserVO;


public class GosuDAO {

	public SqlSession sqlSession;
	
	
	public GosuDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
//	고수목록
	public List<GosuVO> selectAll(Map<String, Integer> pageMap) {
		return sqlSession.selectList("gosu.selectAll", pageMap);
	}
//	페이징처리
	public int getTotal() {
		return sqlSession.selectOne("gosu.getTotal");
	}
	
	public void insert(GosuDTO gosuDTO) {
		sqlSession.insert("gosu.insert", gosuDTO);
	}
	
	public int getSequence() {
		return sqlSession.selectOne("gosu.getSequence");
	}

//	마이페이지에서 필요한 고수Number뽑아오기
	public int getGosuNumber(int userNumber) {
		return sqlSession.selectOne("gosu.getGosuNumber", userNumber);
	}
}
