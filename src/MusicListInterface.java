import java.util.ArrayList;

// The list of music items (an ArrayList of 26 cells,
// representing the letters A to Z, with each cell 
// a Bucket that contains a list of MusicItems whose
// title all start with the letter the cell represents,
// and in sorted order by title.
interface MusicListInterface
{
	
	// Make a bucket for each of the 26 list locations;
	// Set counts of items to zero
	
	public static final int TOTAL_BUCKET_COUNT = 26;
	
	public static final int VALUE_OF_A_CHAR = 65;
	
	// Add an item into the correct bucket in the list
	// Bucket to use is one corresponding to first letter in title
	// Increment the appropriate media count
	public void addItem(MusicItem item);
	
	// Accessors Getter methods
	
	public ArrayList<Bucket> getBuckets();	
	
	public int getAmountOfItem();
	
	public int getAmountOfPaper();
	
	public int getAmountOfCompactMedia();	
	
	public int getAmountOfVinyl();
	
	public int getAmountOfWax();
}
