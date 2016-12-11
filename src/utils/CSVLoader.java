package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.In;
import models.Movie;
import models.Rating;
import models.User;

public class CSVLoader {
	public List<User>  loadUsers(String fileName) throws Exception{
	List<User> users=new ArrayList<User>();
	
	File usersFile = new File(fileName);
    In inUsers = new In(usersFile);
      
    //each field is separated(delimited) by a '|'
    String delims = "[|]";
    while (!inUsers.isEmpty()) {
    	
        // get user and rating from data source
        String userDetails = inUsers.readLine();

        // parse user details string
        String[] userTokens = userDetails.split(delims);

        // output user data to console.
        //==7 as 7 data informations 
        if (userTokens.length == 7) {
        	Long id				= Long.parseLong(userTokens[0]);
			String firstName	= userTokens[1];
			String lastName		= userTokens[2];
			int age				= Integer.parseInt(userTokens[3]);
			String gender		= userTokens[4];
			String occupation	= userTokens[5];
			users.add(new User(id, firstName, lastName, gender, age, occupation));
        }
       else
        {
            throw new Exception("Invalid member length: "+userTokens.length);
        }
    }
    if (users.size()==0){
    	System.out.println("There were no users in the data file");
    }
    return users;
}

	
	public List<Movie> loadMovies(String fileName) throws Exception{
		List<Movie> movies=new ArrayList<Movie>();
		
		File moviesFile = new File(fileName);
		In inMovies = new In(moviesFile);
        
		//each field is separated(delimited) by a '|'
		String delims = "[|]";
		while (!inMovies.isEmpty()) {
    	
        // get movie and rating from data source
			String movieDetails = inMovies.readLine();

        // parse movie details string
			String[] movieTokens = movieDetails.split(delims);

        // output user data to console.
		//==23 as 23 data informations 
			if (movieTokens.length == 23) {
				Long id			= Long.parseLong(movieTokens[0]);
				String title		= movieTokens[1];
				String year			= movieTokens[2];
				String url			= movieTokens[3];
				movies.add(new Movie(id, title, year, url));;
			}
			else
			{	
				throw new Exception("Invalid member length: "+movieTokens.length);
			}
		}		
		if (movies.size()==0){
			System.out.println("There were no movies in the data file");
    }
    return movies;
 }

	
	public List<Rating> loadRatings(String fileName) throws Exception{
	List<Rating> ratings=new ArrayList<Rating>();
	
	File ratingsFile = new File(fileName);
	In inRatings = new In(ratingsFile);
	
	//each field is separated(delimited) by a '|'
	String delims = "[|]";
	while (!inRatings.isEmpty()) {

		// get rating and rating from data source
		String ratingDetails = inRatings.readLine();

		// parse rating details string
		String[] ratingTokens = ratingDetails.split(delims);

		// output user data to console.
		//==4 as 4 data informations 
		if (ratingTokens.length == 4) {
			Long userID			= Long.parseLong(ratingTokens[0]);
			Long movieID		= Long.parseLong(ratingTokens[1]);
			int rating			= Integer.parseInt(ratingTokens[2]);
			
			ratings.add(new Rating(userID, movieID, rating));
		}else
		{
			throw new Exception("Invalid member length: "+ratingTokens.length);
		}
	}
	 if (ratings.size()==0){
	    	System.out.println("There were no ratings in the data file");
	    }
	    return ratings;
 }

}