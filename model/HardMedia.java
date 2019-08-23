package lms.model;

public class HardMedia extends Media{

	public String authorName ;
	public int quantity ;
	static int noOfBooks = 0; // default set up 100

	HardMedia(){
		super(null,0,false);
	}

	HardMedia(String title, String authorName, int quantity){
		super(title,++noOfBooks,true);
		this.authorName = authorName ;
		this.quantity = quantity ;
	}

	/*void dataTest(){

		System.out.println();
		System.out.println("Book Title : " + title);
		System.out.println("Author name : " + authorName);
		System.out.println("Book id : " + id);
		if(availibility)
			System.out.println("Yes Books is available !");
		else
			System.out.println("Sorry ! This book is currently Unavailable ! :( ");
		System.out.println("Quantity of books : " + quantity);
		System.out.println();
	}*/

}