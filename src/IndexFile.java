import java.io.PrintWriter;
import java.io.IOException;

// IndexFile class
public class IndexFile implements IndexFileInterface
{
	
	// This sets up what is necessary for an open, write, and close routines for the index file.
	// It does not describe the file's location.
	private PrintWriter outFileVariable;
	
	// Constructor for IndexFile remains empty.
	public IndexFile()
	{
		// this constructor is empty
	}
		
	// Open index file with name indexFileName
	// for sequential writing
	//
	// Opens a sequential text file to accept 
	// output; prints out report headings
	//
	// Throws IOException if index file cannot
	// be opened or other IO problems occur
	
	// This opens the index file with the passed in parameter name so that the file can be written to.
	// It opens a sequential text file to take in input; it also prints out the report headers.
	// It throws an IOExceptione error if and only if the index file CANNOT
	// be opened, or if there are other IO problems that take place.
	public void open(String indexFileName) throws IOException
	{
		outFileVariable = new PrintWriter(indexFileName);
		
		// Print out all the header titles
		outFileVariable.printf("%-50sACCESSION#  MEDIA  ADDITIONAL INFORMATION\n", "TITLE");
		outFileVariable.println("..................................................................................................");
	}

	// Writes the current line of the report; this is contained inside itemToWrite
	public void writeItem(MusicItem itemToWrite)
	{
		// The following is printed to the outfile index file.
		outFileVariable.printf("%-50s%-11s  %s     %s\n", itemToWrite.getTitle(), itemToWrite.getAccessionNumber(), itemToWrite.getMedia(), itemToWrite.displaySupplementalInfo());
	}

	// This method closes the index file so that resources are not leaked.
	public void close()
	{
		outFileVariable.close();
	}
}
