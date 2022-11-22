package part01;

public class Tune implements ITune{
	private int id;
	private static int  nextId = 1;
	private String title;
	private String artist;
	private int duration;
	private int playCount;
	private Genre style;
	
	
	
	/**Tune
	 * This is a constructor when calling the tune class it will load these variable into the instance 
	 * parameters: title, artist, duration, style in that order
	 * @param title
	 * @param artist
	 * @param duration
	 * @param style
	 */
	public Tune(String title, String artist, int duration , Genre style) {
		setTitle(title);
		setArtist(artist);
		setId();
		setStyle(style);
		this.duration = duration;
		nextId++;
		}
	

	public void setId() {
			this.id = nextId;
			nextId++;
		}
	
	public void setTitle(String title) {
		if (title != null ) {
			this.title =  title;
		}
		else {
			this.title = " ";
		}
		
	}
	
	public void setArtist(String artist) {
		if (artist != null ) {
			this.artist =  artist;
		}
		else {
			this.artist = " ";
		}
	}
		
	public void setStyle(Genre style) {
		this.style = style;
	}
		

	/** ToString this will be used to retrive all data from the instance
	 *  Method toString()
	 *  	returns a formatted String including all details of a Tune in single line.
	 */
	public String toString() {
		String str ="";
		str+= getId() + ", ";
		str+= getTitle() + ", ";
		str+= getArtist() + ", ";
		str+= getDuration() + ", ";
		str+= getStyle() +", ";
		str+= getPlayCount();
		return str;
		
	}
	
	/**GetID
	 * This will get the Id of the tune in the instance
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/**GetTitle
	 * This will get the Title of the tune in the instance
	 */
	public String getTitle() {
		return this.title;
	}
	/**GetArtist
	 * This will get the Artist of the tune in the instance
	 */
	public String getArtist() {
		return this.artist;
	}
	/**GetDuration
	 * This will get the Duration of the tune in the instance
	 */
	public int getDuration() {
		return this.duration;	
	}
	/**GetStyle
	 * This will get the Style of the tune in the instance
	 */
	public String getStyle() {
		return this.style.toString();	
	}
	/**GetPlayCount
	 * This will get the PlayCount of the tune in the instance
	 */
	public int getPlayCount() {
		return this.playCount;
	}
	
// ======================= increment=======================
	/**IncPlayCount
	 * This will increment the play count variable
	 */
	public void incPlayCount() {
		this.playCount++;
	}
	
	/**
	 * Method play()
	 * 		this method should return a String in the following format:
	 * 				“Now Playing ... Four Seasons Winter, by Vivaldi”
	 * 		where “Four Seasons Winter” is the title of a Tune by artist “Vivaldi”
	 *  
	 */
	public String play() {
		String str ="";
		str+="Now playing ... ";
		str+=this.title;
		str+=" , by "+this.artist;
		incPlayCount();
		return str;
		
	}
}
