package com.cognizant.Movie_booking.models;

public class movies {
	private int movie_id;
	private String movie_generes;
	private String movie_name;
	private String movie_cast;
	private String posterimage;
	private int movie_cost;
	/**
	 * 
	 */
	public movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param movie_id
	 * @param movie_generes
	 * @param movie_name
	 * @param movie_cast
	 * @param posterimage
	 * @param movie_cost
	 */
	public movies(int movie_id, String movie_generes, String movie_name, String movie_cast, String posterimage,
			int movie_cost) {
		super();
		this.movie_id = movie_id;
		this.movie_generes = movie_generes;
		this.movie_name = movie_name;
		this.movie_cast = movie_cast;
		this.posterimage = posterimage;
		this.movie_cost = movie_cost;
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
	/**
	 * @return the movie_generes
	 */
	public String getMovie_generes() {
		return movie_generes;
	}
	/**
	 * @param movie_generes the movie_generes to set
	 */
	public void setMovie_generes(String movie_generes) {
		this.movie_generes = movie_generes;
	}
	/**
	 * @return the movie_name
	 */
	public String getMovie_name() {
		return movie_name;
	}
	/**
	 * @param movie_name the movie_name to set
	 */
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	/**
	 * @return the movie_cast
	 */
	public String getMovie_cast() {
		return movie_cast;
	}
	/**
	 * @param movie_cast the movie_cast to set
	 */
	public void setMovie_cast(String movie_cast) {
		this.movie_cast = movie_cast;
	}
	/**
	 * @return the posterimage
	 */
	public String getPosterimage() {
		return posterimage;
	}
	/**
	 * @param posterimage the posterimage to set
	 */
	public void setPosterimage(String posterimage) {
		this.posterimage = posterimage;
	}
	/**
	 * @return the movie_cost
	 */
	public int getMovie_cost() {
		return movie_cost;
	}
	/**
	 * @param movie_cost the movie_cost to set
	 */
	public void setMovie_cost(int movie_cost) {
		this.movie_cost = movie_cost;
	}
	
}