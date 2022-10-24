package com.cognizant.Movie_booking.models;

public class cinemahall {
	private int cinemahall_id;
	private String cinemahall_name;
	private String cinemahall_location;
	private int movie_ID;
	private int no_of_seats;

	public cinemahall() {
		super();
	}

	/**
	 * @param cinemahall_location
	 * @param movie_ID
	 * @param no_of_seats
	 * @param cinemahall_id 
	 * @param cinemahall_name 
	 */
	public cinemahall(String cinemahall_location, int movie_ID, int no_of_seats, int cinemahall_id, String cinemahall_name) {
		super();
		this.cinemahall_id= cinemahall_id;
		this.cinemahall_location = cinemahall_location;
		this.movie_ID = movie_ID;
		this.no_of_seats = no_of_seats;
		this.cinemahall_name = cinemahall_name;
	}

	public int getCinemahall_id() {
		return cinemahall_id;
	}

	public void setCinemahall_id(int cinemahall_id) {
		this.cinemahall_id = cinemahall_id;
	}

	/**
	 * @return the cinemahall_location
	 */
	public String getCinemahall_location() {
		return cinemahall_location;
	}

	/**
	 * @param cinemahall_location the cinemahall_location to set
	 */
	public void setCinemahall_location(String cinemahall_location) {
		this.cinemahall_location = cinemahall_location;
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

	/**
	 * @return the no_of_seats
	 */
	public int getNo_of_seats() {
		return no_of_seats;
	}

	/**
	 * @param no_of_seats the no_of_seats to set
	 */
	public void setNo_of_seats(int no_of_seats) {
		this.no_of_seats = no_of_seats;
	}

	public String getCinemahall_name() {
		return cinemahall_name;
	}

	public void setCinemahall_name(String cinemahall_name) {
		this.cinemahall_name = cinemahall_name;
	}

}