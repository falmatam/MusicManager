import java.util.ArrayList;

public class WaxItem extends MusicItem
{
	// private member variables
	private String waxMaker;
	
	public WaxItem(ArrayList<String> item)
	{
		super(item);// calls the parent constructor
		waxMaker = item.get(3); // wax item, wax maker, is the 3rd item for txt file line item
	}
	
	// Converts information on WaxItem to a string that is used to display the necessary information.
	public String displaySupplementalInfo()
	{
		return "maker: " + waxMaker;
	}
}
