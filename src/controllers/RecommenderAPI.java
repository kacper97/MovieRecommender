package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Movie;
import models.Rating;
import models.Recommendation;
import models.User;
//import utils.Serializer;

public class RecommenderAPI implements RecommenderInterface {

	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	private ArrayList<Rating> ratingIndex = new ArrayList<>();
	//private Serializer serializer;
	
	public void addUser(String firstName, String lastName, int age, String gender, String occupation) {
		 User user = new User (firstName, lastName, gender, age, occupation);
		 userIndex.put(user.getId(), user);
	}

	@Override
	public void removeUser(Long userID) 
	{
		if(userIndex.containsKey(userID)){
			userIndex.remove(userID);
			User.counter--;
		}
			else{
				System.out.println("No user allocated with that ID ");
			}
		}

	@Override
	public void addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.getId(), movie);
	}

	@Override
	public void addRating(Long userID, Long movieID, int rating) 
	{
		ratingIndex.add(new Rating(userID, movieID, rating));
	}

	@Override
	public Movie getMovie(Long movieID) {
		return movieIndex.get(movieID);
	}

	@Override
	public ArrayList<Rating> getUserRatings(Long userID) {
		return (ArrayList<Rating>) userIndex.get(userID).getRatings();
	}

	@Override
	public ArrayList<Recommendation> getUserRecommendations(Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getTopTenMovies() {
		List<Movie> tenMovies = (List<Movie>) movieIndex.values();
		Collections.sort(tenMovies);
		return tenMovies.subList(1,10); // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}
	
	public void store(){
		//for Main method in Main
	}
	
}