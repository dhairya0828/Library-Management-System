package lms.controller;

public class UserNotFoundException extends Exception{

	public String getMessage(){
		return ("\nOops ! User not recognized. Please enter valid User ID.");
	}
}