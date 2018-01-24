package com.drugTodrug.pojo;

public class AdminInfo {

	private String userName;
	private String password;
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminInfo [userName=" + userName + ", password=" + password + "]";
	}

}
