package com.sunny.app.gosu.dto;

//*tbl_gosu (고수)
//gosu_number (pk) //int unsigned auto_increment 
//user_number (fk) //int
//gosu_plan //varchar(3000)

public class GosuDTO {

	private int gosuNumber;
	private int userNumber;
	private String gosuPlan;
	
	public GosuDTO() {
	}

	public int getGosuNumber() {
		return gosuNumber;
	}

	public void setGosuNumber(int gosuNumber) {
		this.gosuNumber = gosuNumber;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getGosuPlan() {
		return gosuPlan;
	}

	public void setGosuPlan(String gosuPlan) {
		this.gosuPlan = gosuPlan;
	}

	@Override
	public String toString() {
		return "GosuDTO [gosuNumber=" + gosuNumber + ", userNumber=" + userNumber + ", gosuPlan=" + gosuPlan + "]";
	}
	
	
}
