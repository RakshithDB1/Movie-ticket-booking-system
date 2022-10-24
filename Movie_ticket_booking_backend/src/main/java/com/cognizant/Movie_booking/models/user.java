package com.cognizant.Movie_booking.models;

public class user {
	
	private int user_id;
	private String user_name;
	private String user_email;
	private String user_mobile;
	private String user_address;
	private String user_password;
	
	public user()
	{
		super();
	}
	/**
	 * @param user_id
	 * @param user_name
	 * @param user_email
	 * @param user_mobile
	 * @param user_address
	 * @param user_password
	 */
	public user(int user_id, String user_name, String user_email, String user_mobile, String user_address,
			String user_password) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_mobile = user_mobile;
		this.user_address = user_address;
		this.user_password = user_password;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the user_email
	 */
	public String getUser_email() {
		return user_email;
	}
	/**
	 * @param user_email the user_email to set
	 */
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	/**
	 * @return the user_mobile
	 */
	public String getUser_mobile() {
		return user_mobile;
	}
	/**
	 * @param user_mobile the user_mobile to set
	 */
	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}
	/**
	 * @return the user_address
	 */
	public String getUser_address() {
		return user_address;
	}
	/**
	 * @param user_address the user_address to set
	 */
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	/**
	 * @return the user_password
	 */
	public String getUser_password() {
		return user_password;
	}
	/**
	 * @param user_password the user_password to set
	 */
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	
	@Override
	public String toString() {
		return "user [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_mobile="
				+ user_mobile + ", user_address=" + user_address + ", user_password=" + user_password + "]";
	}
	

}
