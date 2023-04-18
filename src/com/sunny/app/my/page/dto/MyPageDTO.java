package com.sunny.app.my.page.dto;

import java.util.List;

import com.sunny.app.question.vo.QuestionVO;
import com.sunny.app.story.file.vo.StoryFileVO;
import com.sunny.app.user.file.dto.UserFileDTO;
import com.sunny.app.user.file.vo.UserFileVO;

public class MyPageDTO {
	private int userNumber;
	private String userNickname;
	private String userComment;
	private int gradeNumber;
	private UserFileVO userFile;
	private int followerCnt;
	private int followingCnt;
	private int storyCnt;
	private int gosuNumber;
	private List<StoryFileVO> storyFiles;


	public MyPageDTO() {}


	public int getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}


	public String getUserNickname() {
		return userNickname;
	}


	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}


	public String getUserComment() {
		return userComment;
	}


	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}


	public int getGradeNumber() {
		return gradeNumber;
	}


	public void setGradeNumber(int gradeNumber) {
		this.gradeNumber = gradeNumber;
	}


	public UserFileVO getUserFile() {
		return userFile;
	}


	public void setUserFile(UserFileVO userFile) {
		this.userFile = userFile;
	}


	public int getFollowerCnt() {
		return followerCnt;
	}


	public void setFollowerCnt(int followerCnt) {
		this.followerCnt = followerCnt;
	}


	public int getFollowingCnt() {
		return followingCnt;
	}


	public void setFollowingCnt(int followingCnt) {
		this.followingCnt = followingCnt;
	}


	public int getStoryCnt() {
		return storyCnt;
	}


	public void setStoryCnt(int storyCnt) {
		this.storyCnt = storyCnt;
	}


	public int getGosuNumber() {
		return gosuNumber;
	}


	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}


	public List<StoryFileVO> getStoryFiles() {
		return storyFiles;
	}


	public void setStoryFiles(List<StoryFileVO> storyFiles) {
		this.storyFiles = storyFiles;
	}


	@Override
	public String toString() {
		return "MyPageDTO [userNumber=" + userNumber + ", userNickname=" + userNickname + ", userComment=" + userComment
				+ ", gradeNumber=" + gradeNumber + ", userFile=" + userFile + ", followerCnt=" + followerCnt
				+ ", followingCnt=" + followingCnt + ", storyCnt=" + storyCnt + ", gosuNumber=" + gosuNumber
				+ ", storyFiles=" + storyFiles + "]";
	}

	
	

	
}
