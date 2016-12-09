package models;

import java.util.ArrayList;
import java.util.List;

public  class Movie implements Comparable<Movie> {
	 public static Long counter= 0l;
	 private Long id;
     private String title;
     private String year;
     private String url;
     
     private List<Rating> ratings = new ArrayList<Rating>();
    
     public String getTitle() {
 		return title;
 	}

	public String getYear() {
		return year;
	}

	public String getUrl() {
		return url;
	}
    
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}


	@Override
	public String toString() {
		return "MOVIEID: "+ id +", TITLE: " + title + ", YEAR: " + year + ", URL: " + url;
	}


	public Movie(String title, String year, String url) {
		counter++;
		this.id = counter;
		this.title = title;
		this.year = year;
		this.url = url;
	}
	public Movie(Long id,String title, String year, String url) {
		this.id=id;
		this.title = title;
		this.year = year;
		this.url = url;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void addRating(Rating newRating) {
		ratings.add(newRating);
	}

	@Override
	public int compareTo(Movie arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}