package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTest {
	
	User test = new User("Kacper", "Woloszyn", "Male", 19, "PartTime");
	
	@Test
	public void testUser() {
		assertEquals("Kacper", test.getFirstName());
		assertEquals("Woloszyn", test.getLastName());
		assertEquals("Male", test.getGender());
		assertEquals(19, test.getAge());
		assertEquals("PartTime", test.getOccupation());
	}
	
	@Test
	public void testGetFirstName() {
		assertEquals("Kacper", test.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Woloszyn", test.getLastName());
	}

	@Test
	public void testGetGender() {
		assertEquals("Male", test.getGender());
	}
	
	@Test
	public void testGetAge() {
		assertEquals(19, test.getAge());
	}
	
	@Test
	public void testGetOccupation() {
		assertEquals("PartTime", test.getOccupation());
	}
}