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

import com.cognizant.Movie_booking.models.movies;


@Repository
public class moviesDaoImpl implements moviesDao {
	
	private static final String INSERT_MOVIES_QUERY = "INSERT INTO MOVIES(movie_generes,movie_name,movie_cast,posterimage,movie_cost) values(?,?,?,?,?)";
    private static final String UPDATE_MOVIES_BY_ID_QUERY = "UPDATE MOVIES SET movie_name=? WHERE MOVIE_ID=?";
    private static final String GET_MOVIES_BY_ID_QUERY = "SELECT * FROM MOVIES WHERE movie_id=?";
    private static final String DELETE_MOVIES_BY_ID = "DELETE FROM MOVIES WHERE movie_id=?";
    private static final String GET_MOVIES_QUERY = "SELECT * FROM MOVIES";
    
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final Logger LOGGER= LoggerFactory.getLogger(moviesDaoImpl.class);
	
    
    @Override
	public boolean savemovies(movies movies) {
    	// TODO Auto-generated method stub
    	boolean status = false;
    	try {
    		int update = 0;
    		update= jdbcTemplate.update(INSERT_MOVIES_QUERY,movies.getMovie_generes(),movies.getMovie_name(),movies.getMovie_cast(),movies.getPosterimage(),movies.getMovie_cost());
    		if (update !=0) {
    			status = true;
    		}
    	} catch (Exception e) {
    		LOGGER.info(e.getMessage());
    	}
    	return status;
    }

	@Override
	public movies updatemovies(movies movies) {
		// TODO Auto-generated method stub
		
		 jdbcTemplate.update(UPDATE_MOVIES_BY_ID_QUERY, movies.getMovie_name(), movies.getMovie_id());
		 return movies;
	}

	@Override
	public movies getById(int movie_id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_MOVIES_BY_ID_QUERY, new ResultSetExtractor<movies>() {

			@Override
			public movies extractData(ResultSet rs) throws SQLException, DataAccessException {
				movies movie = new movies();
				while (rs.next()) {
					movies m = new movies();
					m.setMovie_id(rs.getInt(1));
					m.setMovie_generes(rs.getString(2));
					m.setMovie_name(rs.getString(3));
					m.setMovie_cast(rs.getString(4));
					m.setPosterimage(rs.getString(5));
					m.setMovie_cost(rs.getInt(6));
					movie=m;
					
				}
				return movie;
			}
		});

	}

	@Override
	public boolean deleteById(int movie_id) {
		// TODO Auto-generated method stub
		
		boolean status = false;
    	try {
    		int update = 0;
    		update= jdbcTemplate.update(DELETE_MOVIES_BY_ID, movie_id);
    		if (update !=0) {
    			status = true;
    		}
    	} catch (Exception e) {
    		LOGGER.info(e.getMessage());
    	}
    	return status;
		
        
	}

	@Override
	public List<movies> allmovies() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(GET_MOVIES_QUERY,new ResultSetExtractor<List<movies>>() {
			
			@Override
			public List<movies> extractData(ResultSet rs) throws SQLException, DataAccessException{
				List<movies> movieslist= new ArrayList<movies>();
				while (rs.next()) {
					movies m= new movies();
					m.setMovie_id(rs.getInt(1));
					m.setMovie_name(rs.getString(2));
					m.setMovie_generes(rs.getString(3));
					m.setMovie_cast(rs.getString(4));
					m.setPosterimage(rs.getString(5));
					m.setMovie_cost(rs.getInt(6));
					movieslist.add(m);
				}
				return movieslist;
			}
		});
	}

	@Override
	public movies getByname(String movie_name) {
		// TODO Auto-generated method stub
		
		List<movies> m= jdbcTemplate.query("SELECT * FROM movies where movie_name='"+movie_name+"'",new ResultSetExtractor<List<movies>>() {
			
			@Override
			public List<movies> extractData(ResultSet rs) throws SQLException, DataAccessException{
				List<movies> movieslist= new ArrayList<movies>();
				while (rs.next()) {
					movies m= new movies();
					m.setMovie_id(rs.getInt(1));
					m.setMovie_name(rs.getString(2));
					m.setMovie_generes(rs.getString(3));
					m.setMovie_cast(rs.getString(4));
					movieslist.add(m);
				}
				return movieslist;
			}
		});
		return m.get(0);
	}}