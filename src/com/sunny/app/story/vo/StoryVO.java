package com.sunny.app.story.vo;

public class StoryVO {
	private int storyNumber;
	private String storyTitle;
	private String storyContent;
	private int storyViewcnt;
	private String storyDate;
	private String lastUpdate;
	private int userNumber;
	private String userNickname;
	
	public StoryVO() {}

	public int getStoryNumber() {
		return storyNumber;
	}

	public void setStoryNumber(int storyNumber) {
		this.storyNumber = storyNumber;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setStoryTitle(String storyTitle) {
		this.storyTitle = storyTitle;
	}

	public String getStoryContent() {
		return storyContent;
	}

	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}

	public int getStoryViewcnt() {
		return storyViewcnt;
	}

	public void setStoryViewcnt(int storyViewcnt) {
		this.storyViewcnt = storyViewcnt;
	}

	public String getStoryDate() {
		return storyDate;
	}

	public void setStoryDate(String storyDate) {
		this.storyDate = storyDate;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

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

	@Override
	public String toString() {
		return "StoryVO [storyNumber=" + storyNumber + ", storyTitle=" + storyTitle + ", storyContent=" + storyContent
				+ ", storyViewcnt=" + storyViewcnt + ", storyDate=" + storyDate + ", lastUpdate=" + lastUpdate
				+ ", userNumber=" + userNumber + ", userNickname=" + userNickname + "]";
	}
}
