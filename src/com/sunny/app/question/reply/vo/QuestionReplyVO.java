package com.sunny.app.question.reply.vo;

import java.util.Date;

//*tbl_question_reply (질문게시판댓글)
//reply_number (pk) //int unsigned auto_increment primary key
//gosu_number (fk) //int
//question_number (fk) //int
//user_number (fk) //int
//reply_content //varchar(1000)
//reply_date //datetime

public class QuestionReplyVO {

	private int replyNumber;
	private int gosuNumber;
	private int questionNumber;
	private int userNumber;
	private String replyContent;
	private Date replyDate;
	private String userNickName;
	
	public QuestionReplyVO() {
	}

	public int getReplyNumber() {
		return replyNumber;
	}

	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}

	public int getGosuNumber() {
		return gosuNumber;
	}

	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	
	

	public String getUserNickName() {
		return userNickName;
	}

	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	@Override
	public String toString() {
		return "QuestionReplyVO [replyNumber=" + replyNumber + ", gosuNumber=" + gosuNumber + ", questionNumber="
				+ questionNumber + ", userNumber=" + userNumber + ", replyContent=" + replyContent + ", replyDate="
				+ replyDate + ", userNickName=" + userNickName + "]";
	}

}
