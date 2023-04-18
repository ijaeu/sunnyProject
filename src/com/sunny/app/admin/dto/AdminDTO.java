package com.sunny.app.admin.dto;

//SELECT admin_number, admin_id, admin_password, admin_name, admin_team FROM tbl_admin;
public class AdminDTO {
	
	private int adminNumber;
	private String adminId;
	private String adminPassword;
	private String adminName;
	private String adminTeam;
	
	
	public AdminDTO() {}
	
	public AdminDTO(int adminNumber, String adminId) {
		super();
		this.adminNumber = adminNumber;
		this.adminId = adminId;
	}

	public int getAdminNumber() {
		return adminNumber;
	}

	public void setAdminNumber(int adminNumber) {
		this.adminNumber = adminNumber;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminTeam() {
		return adminTeam;
	}

	public void setAdminTeamName(String adminTeam) {
		this.adminTeam = adminTeam;
	}


	@Override
	public String toString() {
		return "AdminDTO [adminNumber=" + adminNumber + ", adminId=" + adminId + ", adminPassword=" + adminPassword
				+ ", adminName=" + adminName + ", adminTeam=" + adminTeam + "]";
	}

	
}