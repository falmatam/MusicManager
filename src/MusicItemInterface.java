// import java.util.*;

// MusicItem contains the fields common to all music items:
//	accession number, title, media code
// The class is used as the basis of all music item types,
//	but since there is no non-specific music item, the class
//	is abstract
abstract interface MusicItemInterface
{
	// Category codes
	public static final String COMPACT = "C";
	public static final String PAPER = "P";
	public static final String WAX_CYLINDER = "W";
	public static final String VINYL = "V";

	// ..and where in input array they are located
	public static final int ACCESSION_NUMBER_POSITION = 0;
	public static final int TITLE_POSITION = 1;
	public static final int MEDIA_CODE_POSITION = 2;


	// outputs all the necessary information in String format
	public abstract String displaySupplementalInfo();

	// Accessors
	public String getAccessionNumber();
	
	public String getTitle();
	
	public String getMedia();
}