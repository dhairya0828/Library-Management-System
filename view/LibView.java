package lms.view ;
import lms.model.DAO ;
import lms.controller.* ;
import java.util.*;

class LibView{
	
	static void intialise(){
		DAO.initData();
	}
	public static void main(String[] args) {

		intialise();

		int userId=0,bookId=0;
		String bookName = "";
		int balance=0;
		Transaction transaction = new Transaction();

		while(true){

		 try{
			System.out.println("\nWhat operation do you want to perform !\n");
			System.out.println("1 : Issue Book ");
			System.out.println("2 : Return Book ");
			System.out.println("3 : Check balance Information ");
			System.out.println("4 : Search Book");
			System.out.println("5 : Exit");
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
				case 5 : System.out.println("\nOkay, Command accepeted Exiting now.\n");
						 System.exit(0);

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