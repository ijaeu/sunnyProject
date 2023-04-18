package com.sunny.app.follow.dto;
//follow_number int unsigned auto_increment primary key,
//user_from int unsigned not null,
//user_to int unsigned not null,
public class FollowDTO {
	private int followNumber;
	private int userFrom;
	private int userTo;
	
	public FollowDTO() {}

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

	@Override
	public String toString() {
		return "FollowDTO [followNumber=" + followNumber + ", userFrom=" + userFrom + ", userTo=" + userTo + "]";
	}
	
	
}
