package lms.model ;

public class Media{

	public String title;
	public int id;
	public boolean availibility;
	

	Media(String title,int id,boolean availibility){

		this.title = title.toUpperCase() ;
		this.id = id ;
		this.availibility = availibility ;
	}

}