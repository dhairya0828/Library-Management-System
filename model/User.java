package lms.model;

public class User{

	public String name,branch ;
	public int id; // Indicates Library Id 
	public int balance ;
	static int userCount = 0; // Inital 100

	User(String name, String branch, int balance){

		this.name = name.toUpperCase();
		this.branch = branch.toUpperCase();
		this.balance = balance ; 
		this.id = ++userCount;
	}
}