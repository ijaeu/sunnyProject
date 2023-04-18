package com.sunny.app.admin.vo;

public class UserDetailVO {

	private int userNumber;
	private String gradeName;
	private String userNickname;
	private String userName;
	private String userPhone;
	private String userEmail;
	private String userDate;
	private int storyCount;
	private int replyCount;
	private int followerCount;
	private int followingCount;
	
	public UserDetailVO() {}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDate() {
		return userDate;
	}

	public void setUserDate(String userDate) {
		this.userDate = userDate;
	}

	public int getStoryCount() {
		return storyCount;
	}

	public void setStoryCount(int storyCount) {
		this.storyCount = storyCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public int getFollowerCount() {
		return followerCount;
	}

	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}

	public int getFollowingCount() {
		return followingCount;
	}

	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}

	@Override
	public String toString() {
		return "UserDetailVO [userNumber=" + userNumber + ", gradeName=" + gradeName + ", userNickname=" + userNickname
				+ ", userName=" + userName + ", userPhone=" + userPhone + ", userEmail=" + userEmail + ", userDate="
				+ userDate + ", storyCount=" + storyCount + ", replyCount=" + replyCount + ", followerCount="
				+ followerCount + ", followingCount=" + followingCount + "]";
	}

	
	
	
}
