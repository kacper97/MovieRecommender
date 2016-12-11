package controllers;

import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utils.Serializer;
import utils.XMLSerializer;

public class Main
{
	
 public Serializer serializer = new XMLSerializer(null);
 public RecommenderAPI recommenderAPI = new RecommenderAPI(); 
 
 @Command(description="Add a new User")
 public void addUser (@Param(name="first name") String firstName, @Param(name="last name") String lastName,
 @Param(name="age") int age, @Param(name="gender") String gender, @Param(name="occupation") String occupation)
 {
	 recommenderAPI.addUser(firstName, lastName, age, gender, occupation);
 }

 @Command(description="Delete a User")
 public void removeUser (@Param(name="id") Long userID)
 {
	 recommenderAPI.removeUser(userID);
 }
 
 @Command(description="Add a Movie")
 public void addMovie (@Param(name="title") String title, @Param(name="year") String year, @Param(name="url") String url)
 {
	 recommenderAPI.addMovie(title, year, url);
 }
 
 //Get a movie
 
 //Get a user rating
 
 //Get a users rating
 
 //Get top 10
 
 //Get user recommendation
 
 public static void main(String[] args) throws Exception
 {
 Main main = new Main();
 Shell shell = ShellFactory.createConsoleShell("lm", "Welcome to likemovie - ?help for instructions", main);
 shell.commandLoop();
 main.recommenderAPI.store();
 }
}