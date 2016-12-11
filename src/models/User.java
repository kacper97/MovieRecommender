package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	 @Override
	 public boolean equals(final Object obj)
	 {
	 if (obj instanceof User)
	 {
	 final User other = (User) obj;
	 return Objects.equals(firstName, other.firstName)
	 && Objects.equals(lastName, other.lastName)
	 && Objects.equals(gender, other.gender)
	 && Objects.equals(age, other.age)
	 && Objects.equals(occupation, other.occupation)
	 && Objects.equals(ratings, other.ratings);
	 }
	 else
	 {
	 return false;
	 }
	}
	 //this is for the get user command from main
	@Override
		public String toString() {
			return "USER ID:" + id + ", FIRSTNAME:" + firstName + ", LAST NAME: " +lastName + ", AGE: " +age + ", GENDER: "+ gender + ", OCCUPATION: " + occupation;
		}
}
	
	