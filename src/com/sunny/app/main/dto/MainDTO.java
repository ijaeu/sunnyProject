package com.sunny.app.main.dto;

import java.util.List;

import com.sunny.app.gosu.vo.GosuVO;
import com.sunny.app.story.vo.StoryListVO;
import com.sunny.app.user.vo.UserVO;

public class MainDTO {
	private List<StoryListVO> storyList;
	private GosuVO gosu;
	
	
	public List<StoryListVO> getStoryList() {
		return storyList;
	}
	public void setStoryList(List<StoryListVO> storyList) {
		this.storyList = storyList;
	}
	public GosuVO getGosu() {
		return gosu;
	}
	public void setGosu(GosuVO gosu) {
		this.gosu = gosu;
	}
	@Override
	public String toString() {
		return "MainDTO [storyList=" + storyList + ", gosu=" + gosu + "]";
	}
	
	
	
	
}
