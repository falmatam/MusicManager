import java.util.LinkedList;

// Bucket class, it is a Linked List that consistts of MusicItems
public class Bucket {

	// private member declaration
	private LinkedList<MusicItem> items;
	
	public Bucket(){
		
		// private member initialization inside the constructor
		items = new LinkedList<MusicItem>();
	}
	
	// Add a music item into the bucket in alphabetical order
	// based on the title.
	public void addItem(MusicItem itemToAdd){
		
		for (int i = 0; i < items.size(); i++){
			
            MusicItem itemToCompare = items.get(i);
            
            // Now compare the title of the itemToAdd with item
            
            if (itemToAdd.getTitle().compareTo(itemToCompare.getTitle()) < 0){ // checks if itemToAdd's title is alphanumerically less than item's title
            	items.add(i, itemToCompare); // if it's less, then add the current string before the other.
            	return; // exit the loop and method
            }
                
		}
		items.add(itemToAdd); // add item to the end of the list, because it is after all the items we just comapred it with.
	}
	
	// Accessor method
	public LinkedList<MusicItem> getItems(){
		return items;
	}

}
