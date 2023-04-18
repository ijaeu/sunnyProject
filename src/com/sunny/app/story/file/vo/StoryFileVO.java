package com.sunny.app.story.file.vo;

public class StoryFileVO {
	private String fileSystemName;
	private int storyNumber;
	private String storyTitle;
	private int userNumber;
	
	public StoryFileVO() {}
	
	public String getFileSystemName() {
		return fileSystemName;
	}
	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}
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
	public int getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	@Override
	public String toString() {
		return "StoryFileVO [fileSystemName=" + fileSystemName + ", storyNumber=" + storyNumber + ", storyTitle="
				+ storyTitle + ", userNumber=" + userNumber + "]";
	}
	
	
	
	
}
