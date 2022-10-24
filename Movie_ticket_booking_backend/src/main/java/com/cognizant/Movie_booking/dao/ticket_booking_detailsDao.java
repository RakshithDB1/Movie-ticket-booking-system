package com.cognizant.Movie_booking.dao;

import java.util.List;

import com.cognizant.Movie_booking.models.ticket_booking_details;

public interface ticket_booking_detailsDao {
	
	public List<ticket_booking_details> getAllticket_booking_details();
	public ticket_booking_details getticket_booking_detailsByMovie_ID(int movie_ID);
	public boolean saveticket(ticket_booking_details t);
	public boolean deleteticket(int ticket_id,int user_id);
 
}
