package part01;

import java.util.Scanner;

public class console {
	// A Scanner for reading data from the keyboard
	static Scanner input = new Scanner(System.in);
	private static MP3Player Player = new MP3Player();

	public static void main(String[] args) {
		String options[] = { "Select from Full List", "Select Tune by Artist", "Add New Tune", "Display the Top 10",
				"Exit" };
		Menu myMenu = new Menu("\nMusic Menu\n", options);

		boolean finished = false;
		do {
			int choice = myMenu.getUserChoice();
			if (choice == options.length) {
				finished = true;
			} else {
				processChoice(choice);
			}
		} while (!finished);
		System.out.println("Goodbye!");
	}

	private static void processChoice(int choice) {
		switch (choice) {
		case 1:
			fullList();
			play();
			break;
		case 2:
			boolean val = artistList();
			if (val == true) {
				play();
			}
			break;
		case 3:
			addTune();
			break;
		case 4:
			topTen();
			break;
		}
	}

	public static void fullList() {
		System.out.println("\nFull List");
		System.out.println("=====================\n\n");
		String str[] = Player.getTuneInfo();
		for (int i = 0; i < str.length;) {
			String[] row = (str[i]).split(",");
			System.out.println("Id: "+row[0]+" Title: "+ row[1]+" Artist: "+row[2]+" Duration: "+row[3]+" seconds Style:"+row[4]);
			i++;
		}
		System.out.println("\n");
	}

	public static boolean artistList() {
		fullList();
		System.out.println("\nSelect Tune by Artist");
		System.out.println("=====================\n\n");
		System.out.println("Enter Artists Name");
		String artistName = input.nextLine();
		if (artistName != "") {
			String str[] = Player.getTuneInfo(artistName);
			if (str != null) {
				if (str.length != 0) {
					for (int i = 0; i < str.length;) {
						String[] row = (str[i]).split(",");
						System.out.println("Id: "+row[0]+" Title: "+ row[1]+" Artist: "+row[2]+" Duration: "+row[3]+" seconds Style:"+row[4]);
						i++;
					}
					System.out.println("\n");
					return true;
				} else {
					System.out.println("Error, No Tunes found for artist: " + artistName);
				}
			} else {
				System.out.println("Error, No Tunes found for artist: " + artistName);
			}
		} else {
			System.out.println("No artist's name entered, please enter an artists name");
		}
		System.out.println("\n");
		return false;
	}

	public static void play() {
		System.out.println("Enter the tune's Id to play ");
		int playId = input.nextInt();
		input.nextLine();
		String str = Player.playTune(playId);
		if (str != null) {
			System.out.println(str);
		} else {
			System.out.println("Error, No Tunes forun at Id: " + playId);
		}
	}

	public static void addTune() {
		System.out.println("\nAdd New Tune");
		System.out.println("============\n\n");
		System.out.println("Please enter the title");
		String title = input.nextLine();
		System.out.println("Please enter the artist");
		String artist = input.nextLine();
		System.out.println("please enter the duration");
		int duration = input.nextInt();
		input.nextLine();
		Genre genre = selectGenre();
		Boolean pass = true;
		if (title == "") {
			System.out.println("Error please enter a value for title.");
			pass = false;
		}
		if (artist == "") {
			System.out.println("Error please enter a value for artist.");
			pass = false;
		}
		if (duration == 0) {
			System.out.println("Error please enter a value for duration.");
			pass = false;
		}
		if (pass == true) {
			boolean ret = Player.addTune(title, artist, duration, genre);
			if (ret == false) {
			System.out.println("Error, the information you entered already exists please ensure that you add new data for both title and artist ");
			}
		}

	}

	public static Genre selectGenre() {
		String options[] = { Genre.ROCK.toString(), Genre.POP.toString(), Genre.DANCE.toString(), Genre.JAZZ.toString(),
				Genre.CLASSICAL.toString(), Genre.OTHER.toString() };
		Menu genSelect = new Menu("Select a Genre", options);
		int choice = genSelect.getUserChoice();
		switch (choice) {
		case 1:
			return Genre.ROCK;
		case 2:
			return Genre.POP;
		case 3:
			return Genre.DANCE;
		case 4:
			return Genre.JAZZ;
		case 5:
			return Genre.CLASSICAL;
		default:
			return Genre.OTHER;
			
		}

	}
	
	public static void topTen() {
		System.out.print(Player.getTopTen());
	}
	
}
