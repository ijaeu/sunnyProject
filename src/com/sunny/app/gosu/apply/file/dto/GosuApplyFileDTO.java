package com.sunny.app.gosu.apply.file.dto;

//*tbl_gosu_apply_file (고수신청첨부파일)
//file_system_name (pk) //varchar(300)
//file_original_name //varchar(300)
//apply_number (fk) //int

public class GosuApplyFileDTO {
	
	private String fileSystemName;
	private String fileOriginalName;
	private int applyNumber;
	
	public GosuApplyFileDTO() {
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

	public int getApplyNumber() {
		return applyNumber;
	}

	public void setApplyNumber(int applyNumber) {
		this.applyNumber = applyNumber;
	}

	@Override
	public String toString() {
		return "GosuApplyFileDTO [fileSystemName=" + fileSystemName + ", fileOriginalName=" + fileOriginalName
				+ ", applyNumber=" + applyNumber + "]";
	}
	
	

}
