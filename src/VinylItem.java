import java.util.ArrayList;


public class VinylItem extends MusicItem
{
	// private member variables
	private String recordLabelImprint;
	
	private int speedOfPlay;
	
	// Constructor
	public VinylItem(ArrayList<String> item)
	{
		super(item); // calls the parent constructor
		recordLabelImprint = item.get(3); // vinyl item, record label imprint, is the 3rd item for txt file line item
		speedOfPlay = Integer.parseInt(item.get(4)); // vinyl item, speed of play, is the 4rd item for txt file line item
	}
	
	// Converts information on VinylItem to a string that is used to display the necessary information.
	public String displaySupplementalInfo()
	{
		return "record label's imprint: " + recordLabelImprint + " | speed of play: "+ speedOfPlay;
	}
}

