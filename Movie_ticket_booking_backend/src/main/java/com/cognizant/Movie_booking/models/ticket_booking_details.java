package com.cognizant.Movie_booking.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class ticket_booking_details {
	private int booking_id;
	private int user_ID;
	private LocalDate booked_date;
	private int seat_no;
	private int movie_ID;
	private LocalTime ticket_time;
	

	/**
	 * @param booked_date
	 * @param seat_no
	 * @param movie_ID
	 * @param booking_id
	 * @param ticket_time
	 */
	public ticket_booking_details(LocalDate booked_date,int user_ID, int seat_no, int movie_ID, int booking_id,
			LocalTime ticket_time) {
		super();
		this.booked_date = booked_date;
		this.user_ID=user_ID;
		this.seat_no = seat_no;
		this.movie_ID = movie_ID;
		this.booking_id = booking_id;
		this.ticket_time = ticket_time;
	}


	/**
	 * @return the booking_id
	 */
	public int getBooking_id() {
		return booking_id;
	}


	/**
	 * @param booking_id the booking_id to set
	 */
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}



	/**
	 * @return the user_ID
	 */
	public int getUser_ID() {
		return user_ID;
	}


	/**
	 * @param user_ID the user_ID to set
	 */
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}


	/**
	 * @return the ticket_time
	 */
	public LocalTime getTicket_time() {
		return ticket_time;
	}


	/**
	 * @param ticket_time the ticket_time to set
	 */
	public void setTicket_time(LocalTime ticket_time) {
		this.ticket_time = ticket_time;
	}


	public ticket_booking_details() {
		super();
	}


	/**
	 * @return the booked_date
	 */
	public LocalDate getBooked_date() {
		return booked_date;
	}

	/**
	 * @param booked_date the booked_date to set
	 */
	public void setBooked_date(LocalDate booked_date) {
		this.booked_date = booked_date;
	}

	/**
	 * @return the seat_no
	 */
	public int getSeat_no() {
		return seat_no;
	}

	/**
	 * @param seat_no the seat_no to set
	 */
	public void setSeat_no(int seat_no) {
		this.seat_no = seat_no;
	}

	/**
	 * @return the movie_ID
	 */
	public int getMovie_ID() {
		return movie_ID;
	}

	/**
	 * @param movie_ID the movie_ID to set
	 */
	public void setMovie_ID(int movie_ID) {
		this.movie_ID = movie_ID;
	}

}
