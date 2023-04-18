package com.sunny.app.story.reply.vo;

public class StoryReplyVO {
	private int replyNumber;
	private String replyContent;
	private String replyDate;
	private int replyViewcnt;
	private int userNumber;
	private int storyNumber;
	private String userNickname;
	
	public StoryReplyVO() {}
	
	public int getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getDateTime() {
		return replyDate;
	}
	public void setDateTime(String dateTime) {
		this.replyDate = dateTime;
	}
	public int getReplyViewcnt() {
		return replyViewcnt;
	}
	public void setReplyViewcnt(int replyViewcnt) {
		this.replyViewcnt = replyViewcnt;
	}
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	public int getStoryNumber() {
		return storyNumber;
	}
	public void setStoryNumber(int storyNumber) {
		this.storyNumber = storyNumber;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	@Override
	public String toString() {
		return "StoryReplyVO [replyNumber=" + replyNumber + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ ", replyViewcnt=" + replyViewcnt + ", userNumber=" + userNumber + ", storyNumber=" + storyNumber
				+ ", userNickname=" + userNickname + "]";
	}
}
