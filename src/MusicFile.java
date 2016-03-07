import java.io.IOException;
import java.util.*;
import java.io.*;
import java.net.URL;

// Music File method
public class MusicFile implements MusicFileInterface
{
	// member variable
	private Scanner inFile;
	
	// Constructor
	public MusicFile()
	{
		// empty constructor.
	}
	
	// Opens the index file with the name of the parameter, indexFileName, and it is used for writing.
	// It opens a text file to acceppt music info and then parses that information.
	// It rhows an IOException if the music file is unable to be opened!
	public void openDiskFile(String indexFileName) throws IOException
	{	
		// Opening the file on a disk
		if (indexFileName.equalsIgnoreCase("music.txt"))
		{
			inFile = new Scanner(new FileReader(indexFileName));
		}		

	}
	
	//Open the file via URL input
	public void openWebFile(String indexFileName) throws IOException
	{	
		URL url = new URL(indexFileName);
		inFile = new Scanner(url.openStream());
	}


	// Checks if there are moreItems in file and returns true if there are, return false otherwise.
	public boolean hasMoreItems()
	{
		return inFile.hasNextLine();
	}

	// Reads and returns just one music item as an ArrayList with type strings
	public ArrayList<String> readItem()
	{
		ArrayList<String> elements = new ArrayList<String>();
		
		String line = inFile.nextLine();
		
		String[] stringArray = line.split("; ");
		for (String item : stringArray)
		{
			elements.add(item);
		}
		
		return elements;
	}

	// Closes the file to avoid resource leakage.
	public void close()
	{
		inFile.close();
	}
}

