package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class RatingTest {
	// long long int
	Rating test= new Rating(33, 1209, 3);
	
	@Test
	public void testRating() {
		assertEquals(33, test.getUserId(),0.001);
		assertEquals(1209, test.getMovieID(),0.001);
		assertEquals(3, test.getmovieRating(),0.001);
	}
	
	@Test
	public void testGetUserID() {
		assertEquals(33, test.getUserId(),0.001);
	}

	@Test
	public void testGetMovieID() {
		assertEquals(1209, test.getMovieID(),0.001);
	}

	@Test
	public void testMovieRating() {
		assertEquals(3, test.getmovieRating(),0.001);
	}
	
}