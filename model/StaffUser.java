package lms.model;

public class StaffUser extends User{

	String proffId;
	StaffUser(String name, String branch, String proffId)
	{
		super(name,branch,4);
	/*	
		this.name = name.toUpperCase();
		this.branch = branch.toUpperCase() ;
		this.balance = 4 ; // for staff 
		this.id = ++userCount;
	*/
	//	System.out.println("Staff : " + id);
		this.proffId = proffId.toUpperCase();
	}
	StaffUser(){
		super(null,null,0);
	}
	/*void dataTest() // to test initalised data
	{	
		System.out.println();
		System.out.println("Catagory : STAFF");
		System.out.println("Name : " + name);
		System.out.println("Branch : " + branch);
		System.out.println("Balance : " + balance);
		System.out.println("Proff id : " + proffId);
		System.out.println("Lib Id : " + id);
		System.out.println();
	}*/
}