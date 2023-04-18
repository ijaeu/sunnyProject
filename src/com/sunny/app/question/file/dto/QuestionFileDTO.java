package com.sunny.app.question.file.dto;

//*tbl_question_file (질문게시판첨부파일)
//file_system_name (pk) //varchar(300)
//file_original_name //varchar(300)
//question_number (fk) //int
//gosu_number (fk)//int

public class QuestionFileDTO {

	private String fileSystemName;
	private String fileOriginalName;
	private int questionNumber;
	private int gosuNumber;
	
	public QuestionFileDTO() {
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

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	public int getGosuNumber() {
		return gosuNumber;
	}

	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}

	@Override
	public String toString() {
		return "QuestionFileDTO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName
				+ ", questionNumber=" + questionNumber + ", gosuNumber=" + gosuNumber + "]";
	}
	
	
	
}
