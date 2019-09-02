package lms.controller;

public class BookNotFoundException extends Exception{
	
	public String getMessage(){
		return ("\nOops ! Book not found. Please Enter valid Book ID.");
	}
	/*public String toString(){
		return "lms.controller"
	} */
}