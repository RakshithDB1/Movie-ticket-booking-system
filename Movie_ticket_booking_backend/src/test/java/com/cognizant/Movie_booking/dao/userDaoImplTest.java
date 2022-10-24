package com.cognizant.Movie_booking.dao;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cognizant.Movie_booking.models.user;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
public class userDaoImplTest {
	@InjectMocks
	private userDaoImpl ud;
	@Mock
	private JdbcTemplate template;
	
	@Test
	public void signupatdaoTest() {
		user u=new user(1,"a","b","c","d","e");
		String sql = "INSERT INTO user VALUES(?,?,?,?,?)";
		when(template.update(sql,u.getUser_name(),u.getUser_email(),u.getUser_mobile(),u.getUser_address(),u.getUser_password())).thenReturn(1);
		assertEquals(true,ud.signupuser(u));
	}
	
}
