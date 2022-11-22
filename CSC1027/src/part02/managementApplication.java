package part02;

import java.util.Scanner;

import part01.Genre;
import part01.Menu;

public class managementApplication {
	static Scanner input = new Scanner(System.in);
	private static Jukebox Player = new Jukebox();

	public static void main(String[] args) {
		String options[] = { "Addition of new Tunes","Setting Price per Play","Exit" };
		Menu myMenu = new Menu("\n\nMusic Menu", options);

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
			addTune();
			break;
		case 2: 
			addCostPerPlay();
			break;
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
				System.out.println(
						"Error, the information you eneered already exists please ensure that you add new data for both title and artist ");
			}
		}

	}

	public static void  addCostPerPlay() {
		System.out.println("Enter a value for how much the juke box should charge per tune ");
		int costIn = input.nextInt();
		input.nextLine();
		String str = Player.setCostPerPlay(costIn);
		System.out.println(str);
		
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

}
