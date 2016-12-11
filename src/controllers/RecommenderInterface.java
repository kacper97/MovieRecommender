package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Movie;
import models.Rating;


public interface RecommenderInterface {
	//Adds a user to the database
	public void addUser(String firstName, String lastName, int age, String gender, String occupation);
	//Removes a user from the database
	public void removeUser(Long userID);
	//Adds a movie to the database
	public void addMovie(String title, String year, String url);
	//Adds a rating from a user on a movie
	public void addRating(Long userID, Long movieID, int movieRating);
	//Gets a movie using its ID
	public Movie getMovie(Long movieID);
	//Gets a list of all the users ratings
	public ArrayList<Rating> getUserRatings(Long userID);
	//Gets a list of all the users Recommendations
	public ArrayList<Movie> getUserRecommendations(Long userID);
	//Gets a list of the top 10 movies.
	public List<Movie> getTopTenMovies();
	//Loads the data
	public void load() throws Exception;
	//Saves the current data
	public void write() throws Exception;

}