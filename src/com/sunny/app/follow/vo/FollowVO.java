package com.sunny.app.follow.vo;

public class FollowVO {
	private int followNumber;
	private int userNumber;
	private int userFrom;
	private int userTo;
	private String userNickname;
	private String fileSystemName;
	private String fileOriginalName;
	private int followingStatus;
	
	public int getFollowingStatus() {
		return followingStatus;
	}

	public void setFollowingStatus(int followingStatus) {
		this.followingStatus = followingStatus;
	}

	public FollowVO() {}
	
	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public int getFollowNumber() {
		return followNumber;
	}

	public void setFollowNumber(int followNumber) {
		this.followNumber = followNumber;
	}

	public int getUserFrom() {
		return userFrom;
	}

	public void setUserFrom(int userFrom) {
		this.userFrom = userFrom;
	}

	public int getUserTo() {
		return userTo;
	}

	public void setUserTo(int userTo) {
		this.userTo = userTo;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
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
		return "FollowVO [followNumber=" + followNumber + ", userNumber=" + userNumber + ", userFrom=" + userFrom
				+ ", userTo=" + userTo + ", userNickname=" + userNickname + ", fileSystemName=" + fileSystemName
				+ ", fileOriginalName=" + fileOriginalName + ", followingStatus=" + followingStatus + "]";
	}



	
	
	
}
