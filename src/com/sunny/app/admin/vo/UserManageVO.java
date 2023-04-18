package com.sunny.app.admin.vo;

public class UserManageVO{
		private int userNumber;
		private String gradeName;
		private String userDate;
		private String userNickname;
		
		public UserManageVO(){}

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

		public String getUserDate() {
			return userDate;
		}

		public void setUserDate(String userDate) {
			this.userDate = userDate;
		}

		public String getUserNickname() {
			return userNickname;
		}

		public void setUserNickname(String userNickname) {
			this.userNickname = userNickname;
		}

		@Override
		public String toString() {
			return "UserManageVO [userNumber=" + userNumber + ", gradeName=" + gradeName + ", userDate=" + userDate
					+ ", userNickname=" + userNickname + "]";
		}

		
		
	}


