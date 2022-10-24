package com.cognizant.Movie_booking.Controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.Movie_booking.models.user;
import com.cognizant.Movie_booking.service.userServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)

public class userControllerTest {
	@InjectMocks
	userController uController;
	@Mock
	private userServiceImpl userService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void TestSignupatcontroller() {
		user u = new user(1, "a", "b", "c", "d", "e");
		ResponseEntity<?> actualresult = new ResponseEntity<Object>("user Inserted", HttpStatus.CREATED);
		when(userService.signup(u)).thenReturn(true);

		assertEquals(actualresult, uController.postCustomer(u));
	}

}
