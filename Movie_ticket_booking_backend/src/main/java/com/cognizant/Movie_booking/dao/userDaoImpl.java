package com.cognizant.Movie_booking.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.Movie_booking.models.user;

@Repository
public class userDaoImpl implements userDao {
	@Autowired
	JdbcTemplate template;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(userDaoImpl.class);
	//List<user> userlist = new ArrayList<user>();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(userDaoImpl.class);

	

	@Override
	public List<user> getAlluser(String email, String password) {
		
		return template.query("select * from user where user_email='"+email+"' and user_password='"+password+"'", new ResultSetExtractor<List<user>>() {

			@Override
			public List<user> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<user> userlist = new ArrayList<user>();
				while (rs.next()) {
					user u = new user();
					u.setUser_id(rs.getInt(1));
					u.setUser_name(rs.getString(2));
					u.setUser_email(rs.getString(3));
					u.setUser_mobile(rs.getString(4));
					u.setUser_address(rs.getString(5));
					u.setUser_password(rs.getString(6));
					userlist.add(u);
					
				}
				return userlist;
			}
		});

	}

	//adding user to database
	@Override
	public boolean signupuser(user u) {
		boolean status = false;
		try {
		int update = 0;
		String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
		update = template.update(sql,u.getUser_name(),u.getUser_email(),u.getUser_mobile(),u.getUser_address(),u.getUser_password());
		if (update != 0) {
		status = true;
		}
		} catch (Exception e) {
		LOGGER.info(e.getMessage());
		}
		return status;
		}
	

	
}
