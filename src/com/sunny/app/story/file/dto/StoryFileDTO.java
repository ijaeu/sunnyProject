package com.sunny.app.story.file.dto;

public class StoryFileDTO {
	private String fileSystemName1;
	private String fileOriginalName1;
	private int storyNumber;
	private String fileSystemName2;
	private String fileSystemName3;
	private String fileOriginalName2;
	private String fileOriginalName3;
	
	public StoryFileDTO() {}

	public String getFileSystemName1() {
		return fileSystemName1;
	}

	public void setFileSystemName1(String fileSystemName1) {
		this.fileSystemName1 = fileSystemName1;
	}

	public String getFileOriginalName1() {
		return fileOriginalName1;
	}

	public void setFileOriginalName1(String fileOriginalName1) {
		this.fileOriginalName1 = fileOriginalName1;
	}

	public int getStoryNumber() {
		return storyNumber;
	}

	public void setStoryNumber(int storyNumber) {
		this.storyNumber = storyNumber;
	}

	public String getFileSystemName2() {
		return fileSystemName2;
	}

	public void setFileSystemName2(String fileSystemName2) {
		this.fileSystemName2 = fileSystemName2;
	}

	public String getFileSystemName3() {
		return fileSystemName3;
	}

	public void setFileSystemName3(String fileSystemName3) {
		this.fileSystemName3 = fileSystemName3;
	}

	public String getFileOriginalName2() {
		return fileOriginalName2;
	}

	public void setFileOriginalName2(String fileOriginalName2) {
		this.fileOriginalName2 = fileOriginalName2;
	}

	public String getFileOriginalName3() {
		return fileOriginalName3;
	}

	public void setFileOriginalName3(String fileOriginalName3) {
		this.fileOriginalName3 = fileOriginalName3;
	}

	@Override
	public String toString() {
		return "StoryFileDTO [fileSystemName1=" + fileSystemName1 + ", fileOriginalName1=" + fileOriginalName1
				+ ", storyNumber=" + storyNumber + ", fileSystemName2=" + fileSystemName2 + ", fileSystemName3="
				+ fileSystemName3 + ", fileOriginalName2=" + fileOriginalName2 + ", fileOriginalName3="
				+ fileOriginalName3 + "]";
	}
}
