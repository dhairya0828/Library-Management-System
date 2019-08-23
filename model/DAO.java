package lms.model;

public class DAO{
	public static StudentUser[] studentUsers = new StudentUser[2];
	public static StaffUser[] staffUsers = new StaffUser[2];
	public static HardMedia[] hardMedias = new HardMedia[2];
//	public static SoftMedia[] softMedias = new SoftMedia[2];

	public static void initData(){

		// Initializing StudentUser with 2 user at the moment (Can be expanded later)
		studentUsers[0] = new StudentUser("Dhairya","Computer","17ce003",5);
		studentUsers[1] = new StudentUser("John","Computer","17ce011",5);

		// Initializing StaffUser with 2 user at the moment (Can be expanded later)
		staffUsers[0] = new StaffUser("Prof. Vyas","Computer","CE0901"); // Dept,JoiningYear,seq
		staffUsers[1] = new StaffUser("Prof. wofl","Computer","CE1173"); 

		// Initializing HardMedia with 2 books at the moment (Can be expanded later)
		hardMedias[0] = new HardMedia("Head First Java","HeadFirsts",5);
		hardMedias[1] = new HardMedia("Subtle Art of not giving f*ck","Mark Manson",3);
		System.out.println("Data Initialised \n");
	}

}