import java.util.ArrayList;



// MusicItem class
public abstract class MusicItem implements MusicItemInterface
{
	// private member variables
	private String accessionNumber;
	private String titleOfMedia;
	private String mediaType;
	
	// Constructor 
	public MusicItem(ArrayList<String> item)
	{
		accessionNumber = item.get(ACCESSION_NUMBER_POSITION);
		titleOfMedia = item.get(TITLE_POSITION);
		mediaType = item.get(MEDIA_CODE_POSITION);
	}
	
	// Outputs the private member variables in a String format that is used to write to the file; it is used in 
	// other classes such as Paper, Wax, etc. 
	public abstract String displaySupplementalInfo();
	
	// The following are:
	// Accessor/Getter methods
	
	public String getAccessionNumber()
	{
		return accessionNumber;
	}
	
	public String getTitle()
	{
		return titleOfMedia;
	}
	
	public String getMedia()
	{
		return mediaType;
	}
}
