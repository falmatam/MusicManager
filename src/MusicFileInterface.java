import java.io.IOException;
import java.util.ArrayList;

public interface MusicFileInterface
{
	
	// Contains a scanner
	
	// openDiskFile opens the file when it's located on the local disk
	// openWebFile opens the file when it's located on the web site
	// Throws IOException if music file cannot be opened or other IO problems occur
	
	public void openDiskFile(String musicFileName) throws IOException;
	public void openWebFile(String musicFileName) throws IOException;
	
	// Are there more items in the file?
	// true = yes (not at end of file); false otherwise
	
	public boolean hasMoreItems();
	
	// Read and return one music item, as as ArrayList<String>
	// Number of attributes will vary depending on type of item read
	// -- but first three are always the same: accession number, title, media code
	// Hint: Read in a line, then use string tokenizer split() method to break
	// it into fields, with ";" (and end of string) as the delimiter
	
	public ArrayList<String> readItem();
	
	// Close the file
	
	public void close();
	
}

