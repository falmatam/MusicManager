import java.util.ArrayList;


// MusicList is a class that has a list of music items with 26 cells
// it's letters are A to Z, each cell has a Bucket that has a list of MusicItems whose
// title starts with the letter the cell represents; alphabetized by title.

public class MusicList implements MusicListInterface
{
	
	// Private variables
	
	// Make an arraylist of buckets for each of the 26 lists, each item count is set to zero initially.
	private ArrayList<Bucket> bucketList;
	
	// Private variables, used in getter functions.
	private int amountOfItems;
	private int amountOfPaper;
	private int amountOfCompactMedia;
	private int amountOfVinyl;
	private int amountOfWax;
	
	// Constructor
	public MusicList()
	{
		bucketList = new ArrayList<Bucket>();
		
		for (int i = 0; i < TOTAL_BUCKET_COUNT; i++)
		{
			Bucket newBucket = new Bucket();
			bucketList.add(newBucket);
		}
	}
	
	// Add an item into the correct bucket in the list
	// Bucket to use is one corresponding to first letter in title
	// Increment the appropriate media count
	
	// Add the item passed into addItem into the correct bucket in the arraylist.
	// The correct buck is the one which has the first letter in the title. This method
	// also increments the correct media count.
	public void addItem(MusicItem item)
	{
		char firstLetter = item.getTitle().toUpperCase().charAt(0);
		
		// Add to the correct bucket.
		int indexOfBucket = firstLetter - VALUE_OF_A_CHAR;
		Bucket bucket = bucketList.get(indexOfBucket);
		
		bucket.addItem(item);
		
		// Increment the amount of items by 1
		amountOfItems += 1;
		
		// conditional statements for all types of MusicItems;
		// The correct media is incremented.
		if (item.getMedia().equalsIgnoreCase(MusicItem.COMPACT))
		{
			amountOfCompactMedia += 1;
		}
		else if (item.getMedia().equalsIgnoreCase(MusicItem.VINYL))
		{
			amountOfVinyl += 1;
		}
		else if (item.getMedia().equalsIgnoreCase(MusicItem.WAX_CYLINDER))
		{
			amountOfWax += 1;
		}	
		else // else if (item.getMedia().equalsIgnoreCase(MusicItem.PAPER))
		{
			amountOfPaper += 1;
		}		
	}
		
	// Accessor/Getter methods
	public ArrayList<Bucket> getBuckets()
	{
		return bucketList;
	}
		
	public int getAmountOfItem()
	{
		return amountOfItems;
	}
		
	public int getAmountOfPaper()
	{
		return amountOfPaper;
	}
		
	public int getAmountOfCompactMedia()
	{
		return amountOfCompactMedia;
	}
		
	public int getAmountOfVinyl()
	{
		return amountOfVinyl;
	}
		
	public int getAmountOfWax()
	{
		return amountOfWax;
	}
}
