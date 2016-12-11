package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	Movie test = new Movie("CSGO", "2012", "www.csgoBlog.com");

	@Test
	public void testMovie() {
		assertEquals("CSGO", test.getTitle());
		assertEquals("2012", test.getYear());
		assertEquals("www.csgoBlog.com", test.getUrl());
	}

	@Test
	public void testGetTitle() {
		assertEquals("CSGO", test.getTitle());
	}

	@Test
	public void testYear() {
		assertEquals("2012", test.getYear());
	}

	@Test
	public void testGetUrl() {
		assertEquals("www.csgoBlog.com", test.getUrl());
	}
}
