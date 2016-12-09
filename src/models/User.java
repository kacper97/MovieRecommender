package models;

import java.util.ArrayList;
import java.util.List;


public class User {

	public static Long counter = 0l;
	private Long id;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String occupation;
	
	private List<Rating> ratings = new ArrayList<>();
	 
	public User(String firstName, String lastName, String gender, int age, String occupation)
	{
		this.setId(counter++);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGender(gender);
		this.setAge(age);
		this.setOccupation(occupation);
	}
	
	public User(Long id, String firstName, String lastName, String gender, int age, String occupation)
	{
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setGender(gender);
		this.setAge(age);
		this.setOccupation(occupation);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}
	
	