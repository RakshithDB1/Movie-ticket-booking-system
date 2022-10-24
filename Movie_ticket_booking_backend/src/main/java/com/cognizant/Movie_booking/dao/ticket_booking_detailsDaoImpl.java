package com.cognizant.Movie_booking.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.Movie_booking.models.ticket_booking_details;

@Repository
public class ticket_booking_detailsDaoImpl implements ticket_booking_detailsDao {
	
	@Autowired
	JdbcTemplate template;
	
	 private static final Logger LOGGER= LoggerFactory.getLogger(ticket_booking_detailsDaoImpl.class);
	
	private static final String INSERT_TICKET_QUERY = "INSERT INTO ticket_booking_details( user_ID, booked_date, seat_no, movie_ID, ticket_time) values(?,?,?,?,?)";
	private static final String DELETE_TICKET_BY_ID = "DELETE FROM MOVIES WHERE booking_id=? and user_ID=?";
	//get all the ticket booking details from the database
	@Override
	public List<ticket_booking_details> getAllticket_booking_details() {
		
		return template.query("select* from ticket_booking_details", new ResultSetExtractor<List<ticket_booking_details>>() {

			@Override
			public List<ticket_booking_details> extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				List<ticket_booking_details> list= new ArrayList<ticket_booking_details>();
				while (rs.next()){
					ticket_booking_details t = new ticket_booking_details();
					t.setBooked_date(rs.getDate(1).toLocalDate());
					t.setMovie_ID(rs.getInt(2));
					t.setBooked_date(rs.getDate(1).toLocalDate());

					t.setSeat_no(rs.getInt(3));
					
					list.add(t);
					}
				return list;
				}
			});
		}
	
	//return the ticket booking details by giving movie id as input
	@Override
	public ticket_booking_details getticket_booking_detailsByMovie_ID(int movie_ID){
		List<ticket_booking_details> list = getAllticket_booking_details();
		for(ticket_booking_details ticket_booking_details : list){
			if(ticket_booking_details.getMovie_ID()== movie_ID){
				return ticket_booking_details;
			}
			
		}
		return null;
	}

	
	public boolean saveticket(ticket_booking_details t)
	{
    	// TODO Auto-generated method stub
		//booking_id, user_ID, booked_date, seat_no, movie_ID, ticket_time
    	boolean status = false;
    	try {
    		int update = 0;
    		update= template.update(INSERT_TICKET_QUERY,t.getBooking_id(),t.getUser_ID(),t.getBooked_date(),t.getSeat_no(),t.getMovie_ID(),t.getTicket_time());
    		if (update !=0) {
    			status = true;
    		}
    	} catch (Exception e) {
    		LOGGER.info(e.getMessage());
    	}
    	return status;
    }

	@Override
	public boolean deleteticket(int ticket_id, int user_id) {
		// TODO Auto-generated method stub
		
		boolean status = false;
    	try {
    		int update = 0;
    		update= template.update(DELETE_TICKET_BY_ID, ticket_id,user_id);
    		if (update !=0) {
    			status = true;
    		}
    	} catch (Exception e) {
    		LOGGER.info(e.getMessage());
    	}
    	return status;
		
        
	}

	
}



