package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.Movie;
import models.Rating;

import models.User;
import utils.Serializer;


public class RecommenderAPI implements RecommenderInterface {

	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	private ArrayList<Rating> ratingIndex = new ArrayList<>();
	private Serializer serializer;
	
	public RecommenderAPI(Serializer serializer) {
		this.serializer = serializer;
	}
	
	@Override
	public void addUser(User user) {
		userIndex.put(user.getId(), user); // id was created when user was started.
	}
	
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
	public void addMovie(Movie movie) {
		movieIndex.put(movie.getId(), movie); 
	}
	
	@Override
	public void addMovie(String title, String year, String url) {
		Movie movie = new Movie(title, year, url);
		movieIndex.put(movie.getId(), movie);
	}

	@Override
	public void addRating(Rating movieRating){
		ratingIndex.put(Movie.counter, movieRating);
	}
	
	@Override
	public void addRating(Long userID, Long movieID, int movieRating) 
	{
		ratingIndex.add(new Rating(userID, movieID, movieRating));
	}
	
	@Override
	public Movie getMovie(Long movieID) {
		return movieIndex.get(movieID);
	}

	@Override
	public ArrayList<Rating> getUserRatings(Long userID) {
		return (ArrayList<Rating>) userIndex.get(userID).getRatings();
	}

	@Override//changed Recommendation to Movie 
	public ArrayList<Movie> getUserRecommendations(Long userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> getTopTenMovies() {
		List<Movie> tenMovies = (List<Movie>) movieIndex.values();
		Collections.sort(tenMovies);
		return tenMovies.subList(1,10); // Returns a view of the portion of this list between the specified fromIndex, inclusive, and toIndex, exclusive.
	}

	//suppress warning = allowing java to do this as usually this would be an illegal state.
	@SuppressWarnings("unchecked")
	@Override
	public void load() throws Exception {
		serializer.read();
		movieIndex = (Map<Long, Movie>)     serializer.pop();	
		userIndex = (Map<Long, User>)     serializer.pop();
		Movie.counter = (Long) serializer.pop();
		User.counter = (Long) serializer.pop();
	}

	@Override
	public void write() throws Exception {
		serializer.push(User.counter);
		serializer.push(Movie.counter);
		serializer.push(userIndex);
		serializer.push(movieIndex);
		serializer.write(); 

	}

	public User getUser(Long userID) {
		return userIndex.get(userID);
	}
}