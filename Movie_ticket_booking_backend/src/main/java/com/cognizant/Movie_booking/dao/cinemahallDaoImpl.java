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

import com.cognizant.Movie_booking.models.cinemahall;

@Repository
public class cinemahallDaoImpl implements cinemahallDao{
	
	private static final String INSERT_CINEMAHALL_QUERY = "INSERT INTO CINEMAHALL(cinemahall_name,cinemahall_location,movie_ID,no_of_seats) values(?,?,?,?)";
    private static final String UPDATE_CINEMAHALL_BY_ID_QUERY = "UPDATE CINEMAHALL SET cinemahhall_name=? WHERE CINEMAHALL_ID=?";
    private static final String GET_CINEMAHALL_BY_ID_QUERY = "SELECT * FROM USER WHERE CINEMAHALL_ID=?";
    private static final String DELETE_CINEMAHALL_BY_ID = "DELETE FROM USER WHERE CINEMAHALL_ID=?";
    private static final String GET_CINEMAHALL_QUERY = "SELECT * FROM CINEMAHALL";
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(cinemahallDaoImpl.class);
	
	@Override
	public boolean savecinemahall(cinemahall cinemahall) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			int update = 0;
			update= jdbcTemplate.update(INSERT_CINEMAHALL_QUERY,cinemahall.getCinemahall_name(),cinemahall.getCinemahall_location(),cinemahall.getMovie_ID(),cinemahall.getNo_of_seats());
			if (update !=0) {
				status = true;
			}
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
		}
		return status;
	}

	@Override
	public cinemahall updatecinemahall(cinemahall cinemahall) {
		// TODO Auto-generated method stub
		 jdbcTemplate.update(UPDATE_CINEMAHALL_BY_ID_QUERY, cinemahall.getCinemahall_name(), cinemahall.getCinemahall_id());
		 return cinemahall;
	}

	@Override
	public cinemahall getById(int cinemahall_id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_CINEMAHALL_BY_ID_QUERY, new ResultSetExtractor<cinemahall>() {

			@Override
			public cinemahall extractData(ResultSet rs) throws SQLException, DataAccessException {
				cinemahall cinemahall = new cinemahall();
				while (rs.next()) {
					cinemahall c = new cinemahall();
					c.setCinemahall_id(rs.getInt(1));
					c.setCinemahall_location(rs.getString(2));
					c.setCinemahall_name(rs.getString(3));
					c.setMovie_ID(rs.getInt(4));
					c.setNo_of_seats(rs.getInt(5));
					cinemahall=c;
					
				}
				return cinemahall;
			}
		});


	}

	@Override
	public boolean deleteById(int cinemahall_id) {
		// TODO Auto-generated method stub
		boolean status = false;
    	try {
    		int update = 0;
    		update= jdbcTemplate.update(DELETE_CINEMAHALL_BY_ID, cinemahall_id);
    		if (update !=0) {
    			status = true;
    		}
    	} catch (Exception e) {
    		LOGGER.info(e.getMessage());
    	}
    	return status;
		
        
	}

	@Override
	public List<cinemahall> allcinemahall() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_CINEMAHALL_QUERY,new ResultSetExtractor<List<cinemahall>>() {
			@Override
			public List<cinemahall> extractData(ResultSet rs) throws SQLException, DataAccessException{
				List<cinemahall> cinemahalllist= new ArrayList<cinemahall>();
				while (rs.next()) {
					cinemahall c= new cinemahall();
					c.setCinemahall_id(rs.getInt(1));
					c.setCinemahall_location(rs.getString(2));
					c.setCinemahall_name(rs.getString(3));
					c.setMovie_ID(rs.getInt(4));
					c.setNo_of_seats(rs.getInt(5));
					cinemahalllist.add(c);
				}
				return cinemahalllist;
			}
		});
	}
}