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
	//initializing new data
	public File data = new File("data.xml");
	private Serializer serializer = new XMLSerializer(data);
	public RecommenderAPI recommenderAPI = new RecommenderAPI(serializer);

	//running the program
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
		List<User> users = loader.loadUsers("MovieRecommenderKW/data/users.dat");
		for (User user : users)
		{
			recommenderAPI.addUser(user);
		}
		
		//Loads Movies from Data
		List<Movie> movies = loader.loadMovies("MovieRecommenderKW/data/items.dat");
		for (Movie movie : movies)
		{
			recommenderAPI.addMovie(movie);
		}
	
		//Loads Ratings from Data
		List<Rating> ratings = loader.loadRatings("MovieRecommenderKW/data/ratings.dat");
		for (Rating rating : ratings)
		{
			recommenderAPI.addRating(rating);
		}
	      recommenderAPI.write();
		}
	//adding a new user
	@Command(description = "Add A New User")
	public void addUser(@Param(name = "first name") String firstName, @Param(name = "last name") String lastName, @Param(name = "age") int age, @Param(name = "gender") String gender, @Param(name = "occupation") String occupation) 
	{
		recommenderAPI.addUser(firstName, lastName, age, gender, occupation);
	}
	
	//deleting a user
	@Command(description = "Delete A User")
	public void removeUser(@Param(name = "id") Long id) 
	{
		recommenderAPI.removeUser(id);
	}
	
	//adding a movie
	@Command(description = "Add A Movie")
	public void addMovie(@Param(name = "title") String title, @Param(name = "year") String year, @Param(name = "url") String url)
	{
		recommenderAPI.addMovie(title, year, url);
	}
	
	//getting a movie
	@Command(description="Get Movie")  //print out movie details using the ID of the movie
	public void getMovie(@Param(name="id") Long id)
	{
		Movie movie=recommenderAPI.getMovie(id);
		if(movie==null)
		{   //NO ID returned for that movie
           System.out.println("This movie does not exist");
		}
		else
		{
			System.out.println(recommenderAPI.getMovie(id).toString()); // prints out the toString from models.Movie
		}
	}

	//gets user
	@Command(description ="Get User")
	public void getUser(@Param(name ="id") Long id) //Gets user by ID 
	{
		User user=recommenderAPI.getUser(id);
		if(user==null)
		{   //no user returned
	       System.out.println("This user does not exist");
		}
		else
		{
		System.out.println(recommenderAPI.getUser(id).toString()); // prints out the toString from models.User
		}
	}
	
	@Command(description = "Get A Users Ratings")
	public void getUserRatings(@Param(name = "user ID") Long userID) 
	{
		// gets the User id 
		System.out.println(recommenderAPI.getUserRatings(userID));
	}

	@Command(description = "Top 10 Movies")
	public void getTop10Movies()
	{
		//gets the top 10
		System.out.println(recommenderAPI.getTopTenMovies());
	}
	
	@Command(description = "Add a Rating")
	public void addRating(@Param(name = "user ID") Long userID, @Param(name = "movie ID") Long movieID, @Param(name = "movie rating") int movieRating)
	{
		//adds the rating 
		recommenderAPI.addRating(userID, movieID, movieRating);
	}
	
}