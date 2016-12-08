package controllers;

import java.util.ArrayList;

import models.Movie;
import models.Rating;
import models.Recommendation;

public interface RecommenderInterface {
	//Adds a user to the database
	public void addUser(String firstName, String lastName, int age, char gender, String occupation);
	//Removes a user from the database
	public void removeUser(double userID);
	//Adds a movie to the database
	public void addMovie(String title, int year, String url);
	//Adds a rating from a user on a movie
	public void addRating(double userID, double movieID, int rating);
	//Gets a movie using its ID
	public Movie getMovie(double movieID);
	//Gets a list of all the users ratings
	public ArrayList<Rating> getUserRatings(double userID);
	//Gets a list of all the users Recommendations
	public ArrayList<Recommendation> getUserRecommendations(double userID);
	//Gets a list of the top 10 movies.
	public ArrayList<Movie> getTopTenMovies();
	//Loads the data
	public void load();
	//Saves the current data
	public void write();

}