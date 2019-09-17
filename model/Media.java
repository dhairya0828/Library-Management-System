package lms.model ;
import java.util.*;

public class Media{

	public String title;
	public int id;
	public boolean availibility;
	public ArrayList<Integer> assigned = new ArrayList();
	

	Media(String title,int id,boolean availibility){

		this.title = title.toUpperCase() ;
		this.id = id ;
		this.availibility = availibility ;
	}

}