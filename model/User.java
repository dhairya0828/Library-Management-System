package lms.model;
import java.util.*;

public class User {

	public String name,branch ;
	public int id; // Indicates Library Id 
	public int balance ;
//	public int[] assigned = new int[4]; // balance is 4 
	public ArrayList<Integer> assigned = new ArrayList();
 	static int userCount = 0; // Inital 100

	User(String name, String branch, int balance){

		this.name = name.toUpperCase();
		this.branch = branch.toUpperCase();
		this.balance = balance ; 
		this.id = ++userCount;
	}
}