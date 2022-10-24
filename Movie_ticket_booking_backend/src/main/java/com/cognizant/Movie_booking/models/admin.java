package com.cognizant.Movie_booking.models;

public class admin {

	private String adminId;
	private String password;

	public admin() {
		super();
	}

	public admin(String adminid, String password) {
		this.adminId = adminid;
		this.password = password;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminid) {
		this.adminId = adminid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminId + ", password=" + password + "]";
	}

}