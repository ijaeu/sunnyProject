package com.sunny.app.admin.vo;

public class HeaderInfoVO {

	private int userCount;
	private int gosuCount;
	private int storyCount;
	private int questionCount;
	private int questionReplyCount;
	public int getUserCount() {
		return userCount;
	}
	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}
	public int getGosuCount() {
		return gosuCount;
	}
	public void setGosuCount(int gosuCount) {
		this.gosuCount = gosuCount;
	}
	public int getStoryCount() {
		return storyCount;
	}
	public void setStoryCount(int storyCount) {
		this.storyCount = storyCount;
	}
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public int getQuestionReplyCount() {
		return questionReplyCount;
	}
	public void setQuestionReplyCount(int questionReplyCount) {
		this.questionReplyCount = questionReplyCount;
	}
	@Override
	public String toString() {
		return "HeaderInfoVO [userCount=" + userCount + ", gosuCount=" + gosuCount + ", storyCount=" + storyCount
				+ ", questionCount=" + questionCount + ", questionReplyCount=" + questionReplyCount + "]";
	}
	
	
	
}
