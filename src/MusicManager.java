import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;



// This class reads in the music file and writes to an external file; it creates a title index and some "media counts" for the collection.
public class MusicManager implements MusicManagerInterface
{
	// private member variable
	private MusicList theMusicList; 
	
	// Constructs the music list
	public MusicManager()
	{
		// Ask user if the file is on disk or on the web
		System.out.print("Welcome to the music manager!  Enter D for disk or W for web: ");
		
		// create a scanner variable to read in values.
		Scanner readInScanner = new Scanner(System.in); 
		
		// read in the the value entered and see if it is d, w, or another value.
		String enteredValue = readInScanner.nextLine().toLowerCase(); 
		
		// create a musicFile variable
		MusicFile theMusicFile = new MusicFile();
		
		// Reading from the music file from the website as opposed to reading from disk
		if (enteredValue.charAt(0) == 'w')
		{
			
			try
			{
				theMusicFile.openWebFile("http://www.christophemagnan.com/ICS45J/ProvidedSourceCode/music.txt");
			}
			catch (IOException e)
			{
				System.out.print("Error 404, URL not found: " + e.getMessage());
				theMusicFile.close();
			}
			catch (Exception e)
			{
				System.out.print("Error opening file: " + e.getMessage());
			}
		}
		
		// Reading from the music file from the disk as opposed to reading from the website
		else if (enteredValue.charAt(0) == 'd')
		{
			
			
			try
			{
				theMusicFile.openDiskFile("music.txt");
			}
			catch (IOException e)
			{
				System.out.print("Error 404, file not found!");
				theMusicFile.close();
				return; 
			}	
		}
		else
		{
			// If an incorrect value is entered, execute the following statement and ask for a new
			// value.
			System.out.print("An incorrect value was entered. Please enter D for disk, or W for web!");
		}
		
		// Create new music list
		theMusicList = new MusicList();
		
		// Take all the items from the inputed list and add them into the music list.
		while (theMusicFile.hasMoreItems())
		{
			// Read a line from the music file
			ArrayList<String> items =  theMusicFile.readItem();
			
			// Construct MusicItem object
			MusicItem musicItem;
			String mediaType = items.get(MusicItem.MEDIA_CODE_POSITION);
			
			if (mediaType.equalsIgnoreCase(MusicItem.COMPACT))
			{
				musicItem = new CompactItem(items);
			}
			else if (mediaType.equalsIgnoreCase(MusicItem.PAPER))
			{
				musicItem = new PaperItem(items);
			}
			else if (mediaType.equalsIgnoreCase(MusicItem.VINYL))
			{
				musicItem = new VinylItem(items);
			}
			else
			{
				musicItem = new WaxItem(items);
			}
			
			theMusicList.addItem(musicItem);
			
		}
		
		// Close file
		theMusicFile.close();
	}
	

	// Make an index file (externally written) that consists of a list of music items;
	// it outputs the media category counts and also a total count of the number of items that are processed.
	public void makeIndexAndDisplayCounts()
	{
		// Write to file
		IndexFile indexedFile = new IndexFile();
		try
		{
			indexedFile.open("index.txt"); // the file is opened.
		}
		catch (IOException e)
		{
			System.out.print("There was an error writing to the file: " + e.getMessage());
			
			indexedFile.close(); // close the file so that the resources are not leaked
		}

		// Iterate over all the bucketsbuckets
		for (Bucket bucket : theMusicList.getBuckets())
		{
			for (MusicItem musicItem : bucket.getItems())
			{
				// Finally, write music to the outfile so that 
				indexedFile.writeItem(musicItem);
			}
		}

		// The index file is closed so that no resources are leaked.
		indexedFile.close();		
		// output message at the end of the program
		System.out.println("\nOutput was written to the following file: index.txt\n");
		
		System.out.println("Total Paper Media item count: " + theMusicList.getAmountOfPaper());
		System.out.println("Total Compact Media item count: " + theMusicList.getAmountOfCompactMedia());
		System.out.println("Total Vinyl Media item count: " + theMusicList.getAmountOfVinyl());
		System.out.println("Total WaxCylinder Media item count: " + theMusicList.getAmountOfWax());
		System.out.println("Total Media Item count: " + theMusicList.getAmountOfItem());
	}
}
