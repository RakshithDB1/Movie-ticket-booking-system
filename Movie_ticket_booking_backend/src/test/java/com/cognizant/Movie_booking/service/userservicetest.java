package com.cognizant.Movie_booking.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.Movie_booking.dao.userDaoImpl;
import com.cognizant.Movie_booking.models.user;


@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
public class userservicetest {

	@InjectMocks
	private userServiceImpl userS1;
	
	@Mock
	private userDaoImpl ud;
	//To check service layer function signupuser
	@Test
	public void testsignup() throws Exception{
		user u1=new user(1,"a","b","c","d","e");
		when(ud.signupuser(u1)).thenReturn(true);
		assertEquals(true,userS1.signup(u1));
		
	}
}

