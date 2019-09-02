package lms.controller;

public class InsufficientBalanceException extends Exception{
	
	public String getMessage(){
		return "\nOops ! User does not have sufficient balance" ;
	}
	/*public String toString(){
		return "lms.controller"
	} */
}