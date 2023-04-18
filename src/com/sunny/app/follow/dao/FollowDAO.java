package com.sunny.app.follow.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.follow.dto.FollowDTO;
import com.sunny.app.follow.vo.FollowVO;

public class FollowDAO {

	
	public SqlSession sqlSession;
	
	
	public FollowDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
//	나를 팔로우하는 사람 리스트
	public List<FollowVO> selectFollower(Map<String, Integer>number) {
		return sqlSession.selectList("follow.selectFollower", number);
	}
	
//	내가 팔로우하는 사람 리스트
	public List<FollowVO> selectFollowing(Map<String, Integer>number) {
		return sqlSession.selectList("follow.selectFollowing", number);
	}
	
//	팔로워, 팔로잉 수 > 마이페이지 로딩할때 사용
	public int selectFollowerCnt(int userNumber) {
		return sqlSession.selectOne("follow.selectFollowerCnt", userNumber);
	}
	public int selectFollowingCnt(int userNumber) {
		return sqlSession.selectOne("follow.selectFollowingCnt", userNumber);
	}
	
//	팔로우하기
	public void insert(FollowDTO followDTO) {
		sqlSession.insert("follow.insert", followDTO);
	}
//	팔로우취소하기
	public void delete(FollowDTO followDTO) {
		sqlSession.delete("follow.delete", followDTO);
	}
	
//	내가 팔로우하고 있는지 확인
	public int checkFollow(FollowDTO followDTO) {
		return sqlSession.selectOne("follow.checkFollow", followDTO);
	}
}
