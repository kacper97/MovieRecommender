package models;

public class Rating {
	private Long userID;
	private Long movieID;
	private int movieRating;
	
	public Rating(Long userID, Long movieID, int movieRating)
	{
		this.userID = userID;
		this.movieID = movieID;
		this.movieRating = movieRating;
	}
	
	public Long getUserId()
	{
		return userID;
	}
	public void setUserID(Long userID)
	{
		this.userID=userID;
	}
	
	public long getmovieRating()
	{
		return movieRating;
	}

	public void setmovieRating(int movieRating) 
	{
		this.movieRating = movieRating;
	}
	
	public Long getMovieID() 
	{
		return movieID;
	}
	public void setMovieID(Long movieID) 
	{
		this.movieID = movieID;
	}
	
	@Override
	public String toString() {
		return "USER ID: '" + userID + ", MOVIEID:" + movieID + ", USER RATING: " + movieRating;
	}
}
