package controllers;

import java.util.ArrayList;

import models.Movie;
import models.Rating;
import models.Recommendation;

public class RecommenderAPI implements RecommenderInterface {

	@Override
	public void addUser(String firstName, String lastName, int age, char gender, String occupation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(double userID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addMovie(String title, int year, String url) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRating(double userID, double movieID, int rating) {
		// TODO Auto-generated method stub

	}

	@Override
	public Movie getMovie(double movieID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Rating> getUserRatings(double userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Recommendation> getUserRecommendations(double userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Movie> getTopTenMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub

	}

	@Override
	public void write() {
		// TODO Auto-generated method stub

	}

}