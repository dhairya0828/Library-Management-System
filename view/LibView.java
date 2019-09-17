package lms.view ;
import lms.model.DAO ;
import lms.controller.* ;
import java.util.*;

class LibView{
	
	static void intialise(){
		DAO.initData();
	}

	static void printAssigned(ArrayList<String> tempList,int ch,int id){
		if(ch == 1){
			System.out.println("\nBook assigned to user id : " + id + " are \n");
			for(String temp : tempList )
				System.out.println(temp);
		}
	}

	public static void main(String[] args){

		intialise();

		int userId=0,bookId=0;
		String bookName = "";
		int balance=0;
		Transaction transaction = new Transaction();

		while(true){

		 try{
			System.out.println("\nWhich operation do you want to perform !\n");
			System.out.println("1 : Issue Book ");
			System.out.println("2 : Return Book ");
			System.out.println("3 : Check balance Information ");
			System.out.println("4 : Search Book");
			System.out.println("5 : Show assigned books");
			System.out.println("6 : Exit");
			System.out.print("Enter choice : ");
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();

			switch(choice){

				case 1 : System.out.println("\nYou need to enter User id AND Book id.");
						 System.out.print("User Id : ");
						 userId = input.nextInt();
						 System.out.print("Book Id : ");
						 bookId = input.nextInt();
						 System.out.println(transaction.issueBook(userId,bookId));
						 break ;

				case 2 : System.out.println("\nYou need to enter User id AND Book id.");
						 System.out.print("User Id : ");
						 userId = input.nextInt();
						 System.out.print("Book Id : ");
						 bookId = input.nextInt();
						 System.out.println(transaction.returnBook(userId,bookId));
						 break ;

				case 3 : System.out.println("\nYou need to enter User id.\n");
						 System.out.print("User Id : ");
						 userId = input.nextInt();
						 if((balance = transaction.checkBalance(userId)) == -1)
						 	System.out.println("\nOops ! not valid user.\n");
						 else
						 	System.out.println("\nYour balance is " + balance);
						 break;

  				case 4 : System.out.println("\nSearch by book name or part of book name !");
  						 System.out.print("Name : ");
						 input.nextLine();
						 bookName = input.nextLine();
						 if((bookName = transaction.searchBook(bookName)) != ""){
							System.out.println("\nBook Found !!");
							System.out.println("Book bookName : " + bookName);
						 }
						 else
						 	System.out.println("\nOops ! Book not found :(");
						 break ;

				case 5 : //showAssignedBook(int id)
						 System.out.println("\nEnter user id to show Books assigned to student !");
						 ArrayList <String> tempList = new ArrayList();
						 int tempCode = 0;
						 int id = -1;
						 
						 System.out.print("Enter User Id : ");
						 userId = input.nextInt();
						 tempList = transaction.showAssigned(userId);
						 tempCode = 1 ;
						 id = userId;	
						 printAssigned(tempList,tempCode,id);
						 break ;

				case 6 : System.out.println("\nOkay, Command accepeted Exiting now.\n");
						 System.exit(0);
				default : System.out.println("\nAhh ! Invalid Choice please try again.\n");

			}
		 }
		 catch(BookNotFoundException bnfe){
		 	System.out.println(bnfe.getMessage());
		 }
		 catch(UserNotFoundException unfe){
		 	System.out.println(unfe.getMessage());
		 }
		 catch(BookNotAvailableException bnae){
		 	System.out.println(bnae.getMessage());
		 }
		 catch(InsufficientBalanceException ibe){
		 	System.out.println(ibe.getMessage());
		 }
		}
	}
}