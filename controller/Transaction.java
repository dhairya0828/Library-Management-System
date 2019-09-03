package lms.controller;
import lms.model.*;


public class Transaction{

	int tempUserId = -5; // some garbage
	int tempBookId = -5; // some garbage
	boolean student = false,staff = false ;


	int validUser(int userId){
	
		for(int i=0;i<DAO.studentUsers.length;i++){
			if(DAO.studentUsers[i].id == userId){
				student = true ; 
				return i;
			}
		}

		for(int i=0;i<DAO.staffUsers.length;i++)
			if(DAO.staffUsers[i].id == userId){
				staff = true ; return i;
			}
		return -1;
	}

	int validBook(int bookId){

		for(int i=0;i<DAO.hardMedias.length;i++)
			if(DAO.hardMedias[i].id == bookId)
				return i;

		return -1;
	}


	public String issueBook(int userId,int bookId) 
	throws UserNotFoundException,BookNotFoundException,
		   InsufficientBalanceException,BookNotAvailableException{
	
		tempUserId = validUser(userId);
		if( tempUserId != -1)
		{
			tempBookId = validBook(bookId);
			if( tempBookId != -1){

				if(student){

					if(DAO.studentUsers[tempUserId].balance == 0)
						//return "\nOops ! User does not have sufficient available balance to issue Book.";
						throw new InsufficientBalanceException();
					DAO.studentUsers[tempUserId].balance--;
					student = false ;

				}
				else if(staff){

					if(DAO.staffUsers[tempUserId].balance == 0)
						//return "\nOops ! User does not have sufficient available balance to issue Book.";	
						throw new InsufficientBalanceException();
					DAO.staffUsers[tempUserId].balance--;
					staff = false ;

				}	
				if(!DAO.hardMedias[tempBookId].availibility)
					//return "\nOops ! Requested Book is currently not available. :( " ;
					throw new BookNotAvailableException();

				DAO.hardMedias[tempBookId].quantity--;
				if(DAO.hardMedias[tempBookId].quantity == 0)
					DAO.hardMedias[tempBookId].availibility = false;

				return ("\nBook " + DAO.hardMedias[tempBookId].title + " Issued SuccessFully.");
			}
			else
				//return ("\nOops ! Book not found. Please Enter valid Book ID.");
				throw new BookNotFoundException();
		}
		else
			//return ("\nOops ! User not recognized. Please enter valid User ID.");
			throw new UserNotFoundException();

	}

	public String returnBook(int userId,int bookId)
	throws UserNotFoundException,BookNotFoundException{

		// Let's hope that user can return book so no need to check balance 

		if((tempUserId = validUser(userId)) != -1){
		
			if((tempBookId = validBook(bookId)) != -1){

				DAO.studentUsers[tempUserId].balance++;
				DAO.hardMedias[tempBookId].quantity++;
				DAO.hardMedias[tempBookId].availibility = true;

				return ("\nBook " + DAO.hardMedias[tempBookId].title + " Returned SuccessFully.");
			}
			else
				//return ("\nOops ! Book not found. Please Enter valid Book ID.");
				throw new BookNotFoundException();
		}
		else
			//return ("\nOops ! User not recognized. Please enter valid User ID.");
			throw new UserNotFoundException();

	}

	public int checkBalance(int userId)
	throws UserNotFoundException{

		if((tempUserId = validUser(userId)) != -1){
			
			if(student){

				student = false ;
				return DAO.studentUsers[tempUserId].balance ;
			}
			else if(staff){

				staff = false ;
				return DAO.staffUsers[tempUserId].balance ;
			}
		}
		//return -1; // invalid user 
		throw new UserNotFoundException();

	} 

	public String searchBook(String bookName)
	throws BookNotFoundException{
		
		for(int i=0;i<DAO.hardMedias.length;i++)
			if(DAO.hardMedias[i].title.indexOf(bookName) != -1)
				return DAO.hardMedias[i].title;
		//return "";
		throw new BookNotFoundException();
	}
}
