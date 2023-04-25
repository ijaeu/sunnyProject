package com.sunny.app.question.vo;

import java.util.List;

import com.sunny.app.question.file.dto.QuestionFileDTO;

public class QuestionReadVO {
	private int questionNumber;
	private int userNumber;
	private int gosuNumber;
	private int followingStatus;
	private String userProfileImg;
	private String userNickname;
	private String questionTitle;
	private String questionContent;
	private String questionDate;
	private String lastUpdate;
	private String questionViewcnt;
	private String questionStatus;
	private String fileSystemName;
	private String profileSystemName;
	private List<QuestionFileDTO> questionFiles;
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getGosuNumber() {
		return gosuNumber;
	}
	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}
	public int getFollowingStatus() {
		return followingStatus;
	}
	public void setFollowingStatus(int followingStatus) {
		this.followingStatus = followingStatus;
	}
	public String getUserProfileImg() {
		return userProfileImg;
	}
	public void setUserProfileImg(String userProfileImg) {
		this.userProfileImg = userProfileImg;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionContent() {
		return questionContent;
	}
	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}
	public String getQuestionDate() {
		return questionDate;
	}
	public void setQuestionDate(String questionDate) {
		this.questionDate = questionDate;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getQuestionViewcnt() {
		return questionViewcnt;
	}
	public void setQuestionViewcnt(String questionViewcnt) {
		this.questionViewcnt = questionViewcnt;
	}
	public String getQuestionStatus() {
		return questionStatus;
	}
	public void setQuestionStatus(String questionStatus) {
		this.questionStatus = questionStatus;
	}
	public String getFileSystemName() {
		return fileSystemName;
	}
	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}
	public String getProfileSystemName() {
		return profileSystemName;
	}
	public void setProfileSystemName(String profileSystemName) {
		this.profileSystemName = profileSystemName;
	}
	public List<QuestionFileDTO> getQuestionFiles() {
		return questionFiles;
	}
	public void setQuestionFiles(List<QuestionFileDTO> questionFiles) {
		this.questionFiles = questionFiles;
	}
	@Override
	public String toString() {
		return "QuestionReadVO [questionNumber=" + questionNumber + ", userNumber=" + userNumber + ", gosuNumber="
				+ gosuNumber + ", followingStatus=" + followingStatus + ", userProfileImg=" + userProfileImg
				+ ", userNickname=" + userNickname + ", questionTitle=" + questionTitle + ", questionContent="
				+ questionContent + ", questionDate=" + questionDate + ", lastUpdate=" + lastUpdate
				+ ", questionViewcnt=" + questionViewcnt + ", questionStatus=" + questionStatus + ", fileSystemName="
				+ fileSystemName + ", profileSystemName=" + profileSystemName + ", questionFiles=" + questionFiles
				+ "]";
	}
	

	 
}
