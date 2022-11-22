package part01;

import java.util.ArrayList;

public class MP3Player implements IPlayer {
	/**Array List
	 * This is a list that holds all of the tune objects that are managed  by this MP3Player. 
	 */
	private ArrayList<Tune> soundData;
	
	
	/**MP3 Player
	 * this is an Constructer, when called creates a new instance to hold all of the instances of tune
	 */
	public MP3Player() {
		this.soundData = new ArrayList<Tune>();
		addTune("Stairway to Heaven", "Led Zeppelin", 1, Genre.ROCK);
		addTune("Uptown Funk", "Bruno Mars", 2, Genre.DANCE);
		addTune("Ave Maria", "Charles Gounod", 3, Genre.CLASSICAL);
		addTune("Take The A Train", "Duke Ellington", 4, Genre.JAZZ);
		addTune("Shivers", "Ed Sheeran", 5, Genre.POP);
		
	}
	/**Play Tune
	 * playTune(int tuneId) – using the integer parameter (representing the id of a Tune) should identify a Tune and ‘play’
	 * it (call the play method for a tune). The method should return null If it does not exist or the result of calling the play
	 * method for a Tune if it does exist.
	 */
	
	public String playTune(int tuneId) {
		for (Tune acct : soundData) { // this will repeat through all of the elements inside of the array list soundData
			int tuneIdStr = acct.getId();// this request will return the id for the tune class
			if (tuneIdStr == tuneId) { // checks the input id to the current tune instances title
				return acct.play();// if the input id matches the current tune instances title it will  return the result of the play method
			}
		}
		return null;// if their is no matches the return null
	}
	
	
	/**Get Tune Info
	 * getTuneInfo() – should return an array of Strings where each String contains full details of a Tune, ordered by Title
	 * and covering all available Tune objects. The method should return null if no Tune object are available
	 */

	public String[] getTuneInfo() {
		int totalRow = soundData.size();// this is to get the number that is in the array list  to create  the String array
		String data[] = new String[totalRow]; // this  the creation of the string array
		int index = 0; // this is an incrementable variable that is used to keep track of which position the loop has reached
		if (totalRow != 0) { // this piece of validation is to ensure that the array list has data in it.
			for (Tune acct : soundData) { // this is an enhanced for loop that will loop through all of of the data in the array list
				data[index] = acct.toString(); // this adds the tune instance to the string list for export.
				index++;
			}
			
			return data; // this will returns the results of the loops
		} else {
			return null;
		}
	}
	
	/**Get Tune Info
	 * getTuneInfo(String artist) – should return an array (as above) for Tune objects by a specific artist, specified by the
	 * String parameter. Again, the data should be ordered by Title. The method should return null if no Tune objects are
	 * available
	 */

	public String[] getTuneInfo(String artist) {
		int num = 0; // this variable will be used to get the number of positions the String array should make
		for (Tune tune : soundData) {// this is an enhanced for loop that will loop through all of of the data in the array list
			String artStr = tune.getArtist();// this is the variable from the tune instance the enhanced for loops pointer is currently at
			if (((artStr.equals(artist)) == true)) { // the comparasion is to check if the two artists variables are equal
				num++;// increments the num
			}
		}
		String[] data = new String[num]; // an array list is created based of the variable num.
		int index = 0;// creates an incremental variable to be used to keep track of the position in the array  list
		for (Tune acct : soundData) {// this is an enhanced for loop that will loop through all of of the data in the array list
			String artistStr = acct.getArtist();// this is the variable from the tune instance the enhanced for loops pointer is currently at
			if ((artistStr.equals(artist)) == true) {// this if statement compares the artist to the Instance variable for artist 
				data[index] = (acct.toString()); // this adds the tune instance to the string list for export.
				System.out.println(acct.toString());
				index++;
			}
		}

		return data;
	}
	/**Add Tune
	 * addTune(String title, String artist, int duration, Genre gen) – this method should create and add a new Tune object
	 * to the soundData ArrayList if it’s not already present. Two Tune objects are considered to be the same if they have
	 * the same title and artist
	 */
	public boolean addTune(String title, String artist, int duration, Genre style) { // takes the inputs for the variable of tune
		int index = 0;
		boolean pass = true;
		for (Tune tune : soundData) {// this is an enhanced for loop that will loop through all of of the data in the array list
			String checkTitle = tune.getTitle();// this is the variable from the tune instance the enhanced for loops pointer is currently at
			String checkArtist = tune.getArtist();// this is the variable from the tune instance the enhanced for loops pointer is currently at
			if (checkArtist.equals(artist)==true) {// this if statement compares the artist to the Instance variable for artist 
				if ((checkTitle.equals(title)) && (checkArtist.equals(artist))) {// this is to ensure that their is no repittion of the input data
					return false;
				}
			}
		}
		if (pass == true) {// if their has been no matches then the it will proceed to adding the data to the arraylist
			if (soundData.size() != 0) {
				for (Tune acct : soundData) {// this is an enhanced for loop that will loop through all of of the data in the array list
					String[] point = acct.toString().split(", ");// this will split the string into all of its parts.
					String titleInArray = point[1]; // the title of the tune will be very important
					if (titleInArray.compareToIgnoreCase(title) > 0) {// this if statement will compare to find which is alphabetically smaller.
						break;// once found the code will break out skipping the next incremetataion.
					}
					index++;
				}
				Tune data = new Tune(title, artist, duration, style);// this is a  refrence to all of the data needed to create a tune instance
				soundData.add(index, data); // the index will give reference to where to place the tune in the array list to match the insertion sort

				return true;
			} else {
				Tune data = new Tune(title, artist, duration, style); // if their is no other tune in the arraylist then it will just added to the system.
				soundData.add(data);

				return true;
			}
		}
		return false;
	}

	public String getTopTen() {
		int num = 0; // this is a integer that is used to create the arrays later
		for (Tune tune : soundData) {
			num++;
		}
		int[] data = new int[num];
		String[] str = new String[num];
		int index = 0;
		for (Tune acct : soundData) {// this is an enhanced for loop that will loop through all of of the data in the array list
			data[index] = acct.getPlayCount(); // this is setting the data for the integer array
			str[index] = acct.toString(); //  this is setting the data for the string array
			index++;
		}
		int swaps;
		do {
			swaps = 0;
			for (int i = 0; i < data.length - 1; i++) {
				if (data[i] < data[i + 1]) {
					int temp = data[i];
					String tempStr = str[i];
					data[i] = data[i + 1];//as the data array is sorted by the bubble sort so is the String Array
					str[i] = str[i + 1];  // 
					data[i + 1] = temp;
					str[i + 1] = tempStr;
					swaps++;
				}
			}
		} while (swaps > 0);
		String out = "";
		for (int j = 0; j < data.length; j++) {
			if(j<11) {
				out += str[j] + "\n";
			}
		}
		return out;
	}
}
