package com.sunny.app.admin.vo;

public class GosuManageVO{
	
	private int userNumber;
	private int gosuNumber;
	private String userNickname;
	private int questionCount;
	private int answerCount;
	private String fieldNames;

		
		public GosuManageVO(){}


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


		public String getUserNickname() {
			return userNickname;
		}


		public void setUserNickname(String userNickname) {
			this.userNickname = userNickname;
		}


		public int getQuestionCount() {
			return questionCount;
		}


		public void setQuestionCount(int questionCount) {
			this.questionCount = questionCount;
		}


		public int getAnswerCount() {
			return answerCount;
		}


		public void setAnswerCount(int answerCount) {
			this.answerCount = answerCount;
		}


		public String getFieldNames() {
			return fieldNames;
		}


		public void setFieldNames(String fieldNames) {
			this.fieldNames = fieldNames;
		}


		@Override
		public String toString() {
			return "GosuManageVO [userNumber=" + userNumber + ", gosuNumber=" + gosuNumber + ", userNickname="
					+ userNickname + ", questionCount=" + questionCount + ", answerCount=" + answerCount
					+ ", fieldNames=" + fieldNames + "]";
		}

	

	}


