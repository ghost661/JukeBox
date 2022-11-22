package part02;

import java.util.Scanner;

import part01.Menu;

public class userApplication {

		static Scanner input = new Scanner(System.in);
		private static Jukebox Player = new Jukebox();

		public static void main(String[] args) {
			String options[] = { "Select from Full List", "Select Tune by Artist", "Add Money","Exit" };
			Menu myMenu = new Menu("\nMusic Menu", options);

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
				addMoney();
				break;
			}
		}

		public static void fullList() {
			System.out.println("\nSelect From Full List");
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
			System.out.println("\nSelect From Full List");
			System.out.println("=====================\n");
			System.out.println("Please enter an Artists name.");
			String artistName = input.nextLine();
			String str[] = Player.getTuneInfo(artistName);
			for (int i = 0; i < str.length;) {
				String[] row = (str[i]).split(",");
				System.out.println("Id: "+row[0]+" Title: "+ row[1]+" Artist: "+row[2]+" Duration: "+row[3]+" seconds Style:"+row[4]);
				i++;
			}
			System.out.println("\n");
			if (str.length>0) {
				return true;
			}else {
				return false;
				}
		}

		public static void play() {
			System.out.println("Enter the tune's Id to play ");
			int playId = input.nextInt();
			input.nextLine();
			String str = Player.playTune(playId);
			System.out.println(str);
		}

		public static void  addMoney() {
			System.out.println("Enter a coin to the jukebox you may add (10, 20, 50, 100, 200) pence to the jukebox ");
			int coinIn = input.nextInt();
			input.nextLine();
			String str = Player.insertCoin(coinIn);
			System.out.println(str);
			
		}
		

	

}
