package com.sunny.app.story.dto;

//story_number int unsigned auto_increment primary key,
//story_title varchar(300) not null,
//story_content varchar(3000) not null,
//story_viewcnt int unsigned,
//story_date datetime,
//last_update datetime,
//user_number int unsigned not null,


public class StoryDTO {
	private int storyNumber;
	private String storyTitle;
	private String storyContent;
	private String storyContent2;
	private String storyContent3;	
	private int storyViewcnt;
	private String storyDate;
	private String lastUpdate;
	private int userNumber;
	private String fileSystemName;
	private String fileOriginalName;
	
	public StoryDTO() {}

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

	public String getStoryContent2() {
		return storyContent2;
	}

	public void setStoryContent2(String storyContent2) {
		this.storyContent2 = storyContent2;
	}

	public String getStoryContent3() {
		return storyContent3;
	}

	public void setStoryContent3(String storyContent3) {
		this.storyContent3 = storyContent3;
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

	public String getFileSystemName() {
		return fileSystemName;
	}

	public void setFileSystemName(String fileSystemName) {
		this.fileSystemName = fileSystemName;
	}

	public String getFileOriginalName() {
		return fileOriginalName;
	}

	public void setFileOriginalName(String fileOriginalName) {
		this.fileOriginalName = fileOriginalName;
	}

	@Override
	public String toString() {
		return "StoryDTO [storyNumber=" + storyNumber + ", storyTitle=" + storyTitle + ", storyContent=" + storyContent
				+ ", storyContent2=" + storyContent2 + ", storyContent3=" + storyContent3 + ", storyViewcnt="
				+ storyViewcnt + ", storyDate=" + storyDate + ", lastUpdate=" + lastUpdate + ", userNumber="
				+ userNumber + ", fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName + "]";
	}
}
