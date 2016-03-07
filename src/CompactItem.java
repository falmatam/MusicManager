import java.util.ArrayList;



public class CompactItem extends MusicItem
{
	// Private member variables
	private int countOfItemTracks;
	
	private int yearItemReleased;
	
	// Constructor for CompactItem
	public CompactItem(ArrayList<String> item)
	{
		super(item); // calls the parent constructor
		
		countOfItemTracks = Integer.parseInt(item.get(3)); // number of tracks is the 3rd item for compact media
		
		yearItemReleased = Integer.parseInt(item.get(4));// number of tracks is the 4th item for compact media
	}
	
	// Converts information on CompactItem to a string that is used to display the necessary information.
	public String displaySupplementalInfo()
	{
		return "number of tracks: " + countOfItemTracks + " || year of release: "+ yearItemReleased;
	}
}
