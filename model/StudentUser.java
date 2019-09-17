package lms.model ;

public class StudentUser extends User{

	public String rollNo;
	public int semester;

	StudentUser(String name, String branch, String rollNo, int semester)
	{
	/*	
		this.name = name.toUpperCase();
		this.branch = branch.toUpperCase() ;
		this.balance = 4 ; // for students 
		this.id = ++userCount;
	*/
		super(name,branch,4);
	//	System.out.println("student : " + id);
		this.rollNo = rollNo.toUpperCase() ;
		this.semester = semester ;		
	}
	StudentUser(){
		super(null,null,0);
		semester = 0;
	}
	/*
	void dataTest() // to test initalised data
	{
		System.out.println();
		System.out.println("Catagory : STUDENT");
		System.out.println("Name : " + name);
		System.out.println("Branch : " + branch);
		System.out.println("Roll No. : " + rollNo);
		System.out.println("Semester : " + semester);
		System.out.println("Balance : " + balance);
		System.out.println("Lib Id : " + id);
		System.out.println();
	}*/
}	