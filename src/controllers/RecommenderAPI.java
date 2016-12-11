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


public class RecommenderAPI implements RecommenderInterface 
{
	//hashmaps and arraylists for INDEXES.
	private Map<Long, User> userIndex = new HashMap<>();
	private Map<Long, Movie> movieIndex = new HashMap<>();
	private ArrayList<Rating> ratingIndex = new ArrayList<>();
	private Serializer serializer;
	
	public RecommenderAPI(Serializer serializer) 
	{
		this.serializer = serializer;
	}
	
	@Override
	public void addUser(User user)
	{
		userIndex.put(user.getId(), user); // id was created when user was started.
	}
	
	public void addUser(String firstName, String lastName, int age, String gender, String occupation) 
	{
		 User user = new User (firstName, lastName, gender, age, occupation); // //the id for map key is already obtained
		 userIndex.put(user.getId(), user);
	}

	@Override
	public void removeUser(Long userID) 
	{
		if(userIndex.containsKey(userID))
		{
			userIndex.remove(userID);
			User.counter--; //removing users by ID if the userIndex hashmap contains the key of USER ID
		}
			else
			{
				System.out.println("No user allocated with that ID ");
			}
		}

	@Override
	public void addMovie(Movie movie) 
	{
		movieIndex.put(movie.getId(), movie); // getting ID for movie
	}
	
	@Override
	public void addMovie(String title, String year, String url) 
	{
		Movie movie = new Movie(title, year, url); // the id for map key obtained.
		movieIndex.put(movie.getId(), movie);
	}
	
	@Override
	public Movie getMovie(Long movieID) 
	{
		return movieIndex.get(movieID); // returning the movie ID
	}
	
	@Override    //method to return a user details
	public User getUser(Long userID) 
	{
		return userIndex.get(userID);  //returning the user ID .
	}

	@Override
	public ArrayList<Rating> getUserRatings(Long userID)
	{
		return (ArrayList<Rating>) userIndex.get(userID).getRatings();  //getting the ratings for a certain user.
	}

	@Override
	public List<Movie> getTopTenMovies()
	{
		List<Movie> tenMovies = (List<Movie>) movieIndex.values();
		Collections.sort(tenMovies);
		return tenMovies.subList(1,10);// returns value from index inclusive to exclusive
	}
	

	@Override
	public ArrayList<Movie> getUserRecommendations(Long userID) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	//suppress warning = allowing java to do this as usually this would be an illegal state.
	@SuppressWarnings("unchecked")
	@Override
	public void load() throws Exception
	{
		serializer.read();
		movieIndex = (Map<Long, Movie>)     serializer.pop();	
		userIndex = (Map<Long, User>)     serializer.pop();
		Movie.counter = (Long) serializer.pop();
		User.counter = (Long) serializer.pop();
	}

	@Override
	public void write() throws Exception
	{
		serializer.push(User.counter);
		serializer.push(Movie.counter);
		serializer.push(userIndex);
		serializer.push(movieIndex);
		serializer.write(); 

	}

	@Override
	public void addRating(Rating movieRating)
	{
	movieIndex.get(movieRating.getMovieID()).addRating(movieRating);
	}

	@Override
	public void addRating(Long userID, Long movieID, int movieRating) 
	{
	ratingIndex.add(new Rating(userID, movieID, movieRating));
	}
}
