package lms.controller;

public class BookNotAvailableException extends Exception{
	
	public String getMessage(){
		return "\nOops ! Requested Book is currently not available. :( " ;
	}
	/*public String toString(){s
		return "lms.controller"
	} */
}