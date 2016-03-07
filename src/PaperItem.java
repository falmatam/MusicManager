import java.util.ArrayList;

public class PaperItem extends MusicItem
{
	private int pagesCount;
	
	// Constructor for PaperItem
	public PaperItem(ArrayList<String> item)
	{
		super(item); // calls the parent constructor
		pagesCount = Integer.parseInt(item.get(3)); // paper item, paper count, is the 3rd item for txt file line item
	}
	
	// Converts information on PaperItem to a string that is used to display the necessary information.
	public String displaySupplementalInfo()
	{
		return "number of pages: "+ pagesCount; //returns number of pages
	}
}
