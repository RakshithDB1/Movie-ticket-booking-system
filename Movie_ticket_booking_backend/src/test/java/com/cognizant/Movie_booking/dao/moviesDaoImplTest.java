package com.cognizant.Movie_booking.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.cognizant.Movie_booking.dao.moviesDaoImpl;
import com.cognizant.Movie_booking.models.movies;


// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
@ExtendWith(SpringExtension.class)
public class moviesDaoImplTest {


	// @InjectMocks annotation is used to create and inject the mock object

	@InjectMocks
	moviesDaoImpl mdi = new moviesDaoImpl();

	@Mock
	private JdbcTemplate template;

	@Test
	public void saveMovieTest() {
		movies m = new movies(4,"a", "b", "c", "d",3);
		String sql = "INSERT INTO MOVIES(movie_generes,movie_name,movie_cast,posterimage,moviescost) values(?,?,?,?,?)";
		when(template.update(sql ,m.getMovie_generes(), m.getMovie_name(), m.getMovie_cast(),
				m.getPosterimage(),m.getMovie_cost())).thenReturn(7);
		assertEquals(true, mdi.savemovies(m));
	}

}
