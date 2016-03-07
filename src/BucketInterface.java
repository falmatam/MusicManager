import java.util.LinkedList;

// A bucket contains an alphabetical list, by title, of music items.
interface BucketInterface
{
	
	// A bucket is a list of music items
	
	// public Bucket()
	
	// Add the music item into the bucket,
	// in alphabetical order by title
	public void addItem(MusicItem itemToAdd);
	
	// Accessor -- get the list
	public LinkedList<MusicItem> getItems();
	
}
