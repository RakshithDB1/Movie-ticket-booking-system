package com.cognizant.Movie_booking.models;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class payment {
	private int payment_id;
	private Date payment_date;
	private String movie_cost;
	private Time payment_time;
	private int user_id;
	private int movie_id;
	/**
	 * 
	 */
	public payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param payment_id
	 * @param payment_date
	 * @param movie_cost
	 * @param payment_time
	 * @param user_id
	 * @param movie_id
	 */
	public payment(int payment_id, Date payment_date, String movie_cost, Time payment_time, int user_id,
			int movie_id) {
		super();
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.movie_cost = movie_cost;
		this.payment_time = payment_time;
		this.user_id = user_id;
		this.movie_id = movie_id;
	}
	/**
	 * @return the payment_id
	 */
	public int getPayment_id() {
		return payment_id;
	}
	/**
	 * @param payment_id the payment_id to set
	 */
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	/**
	 * @return the payment_date
	 */
	public Date getPayment_date() {
		return payment_date;
	}
	/**
	 * @param payment_date the payment_date to set
	 */
	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}
	/**
	 * @return the movie_cost
	 */
	public String getMovie_cost() {
		return movie_cost;
	}
	/**
	 * @param movie_cost the movie_cost to set
	 */
	public void setMovie_cost(String movie_cost) {
		this.movie_cost = movie_cost;
	}
	/**
	 * @return the payment_time
	 */
	public Time getPayment_time() {
		return payment_time;
	}
	/**
	 * @param payment_time the payment_time to set
	 */
	public void setPayment_time(Time payment_time) {
		this.payment_time = payment_time;
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
	 * @return the movie_id
	 */
	public int getMovie_id() {
		return movie_id;
	}
	/**
	 * @param movie_id the movie_id to set
	 */
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

}