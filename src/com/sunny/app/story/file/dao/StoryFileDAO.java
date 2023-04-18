package com.sunny.app.story.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.config.MyBatisConfig;
import com.sunny.app.story.file.dto.StoryFileDTO;

public class StoryFileDAO {

	
	public SqlSession sqlSession;
	
	
	public StoryFileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void insert(StoryFileDTO storyfileDTO) {
		System.out.println("storyFileInsert메소드");
		sqlSession.insert("storyFile.insert",storyfileDTO);
	}
	
	public List<StoryFileDTO> select(int storyNumber) {
		return sqlSession.selectList("storyFile.select",storyNumber);
	}
	
	public void delete(int storyNumber) {
		sqlSession.delete("storyFile.delete", storyNumber);
	}
	
	public void update(StoryFileDTO storyFileDTO) {
		sqlSession.update("storyFile.update",storyFileDTO);
	}
}
