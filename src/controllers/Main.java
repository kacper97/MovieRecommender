package controllers;

import java.io.File;
import java.util.List;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import models.Movie;
import models.Rating;
import models.User;
import utils.CSVLoader;
import utils.Serializer;
import utils.XMLSerializer;

public class Main 
{
	public File data = new File("data.xml");
	private Serializer serializer = new XMLSerializer(data);
	public RecommenderAPI recommenderAPI = new RecommenderAPI(serializer);


	 public static void main(String[] args) throws Exception
	 {
	 Main main = new Main();
	 Shell shell = ShellFactory.createConsoleShell("lm", "Welcome to likemovie - ?help for instructions", main);
	 shell.commandLoop();
	 main.recommenderAPI.write();
	}
	
	public void load() throws Exception
	{
		//if the data.xml exist load it
		if (data.isFile())
		{
			recommenderAPI.load();
		}
		
		CSVLoader loader = new CSVLoader();
		//Loads users from Data
		List<User> users = loader.loadUsers("data/users.dat");
		for (User user : users)
		{
			recommenderAPI.addUser(user);
		}
		
		//Loads Movies from Data
		List<Movie> movies = loader.loadMovies("data/items.dat");
		for (Movie movie : movies)
		{
			recommenderAPI.addMovie(movie);
		}
		//Loads Ratings from Data
		List<Rating> ratings = loader.loadRatings("data/ratings.dat");
		for (Rating rating : ratings)
		{
			recommenderAPI.addRating(rating);
		}
	      recommenderAPI.write();
		}
	
	@Command(description = "Add A New User")
	public void addUser(@Param(name = "first name") String firstName, @Param(name = "last name") String lastName,
			@Param(name = "age") int age, @Param(name = "gender") String gender, @Param(name = "occupation") String occupation) {
		recommenderAPI.addUser(firstName, lastName, age, gender, occupation);
	}

	@Command(description = "Delete A User")
	public void removeUser(@Param(name = "id") Long id) {
		recommenderAPI.removeUser(id);
	}

	@Command(description = "Add A Movie")
	public void addMovie(@Param(name = "title") String title, @Param(name = "year") String year,
			@Param(name = "url") String url) {
		recommenderAPI.addMovie(title, year, url);
	}

	@Command(description = "Add a Rating")
	public void addRating(@Param(name = "user ID") Long userID, @Param(name = "movie ID") Long movieID, @Param(name = "movie rating") int movieRating)
	{
		recommenderAPI.addRating(userID, movieID, movieRating);
	}
	
	@Command(description = "Get A Movie")
	public void getMovie(@Param(name = "movie ID") Long id) {
		recommenderAPI.getMovie(id);
	}
	
	@Command(description = "Get A Users Ratings")
	public void getUserRatings(@Param(name = "user ID") Long userID) {
		recommenderAPI.getUserRatings(userID);
	}
	
	@Command(description = "Top 10 Movies")
	public void getTop10Movies() {
		recommenderAPI.getTopTenMovies();
	}


}