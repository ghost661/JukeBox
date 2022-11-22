package part03;

import part01.MP3Player;
import part01.Tune;

public class testMP3Player {
	public static MP3Player plr = new MP3Player();

	
	public static void main(String[] args) {
		test9();
		test10();
		test11();
		
		
	}

	public  static void test9() {
		// Test Id: TC9
		// This method tests the behaviour of the 'toString' method.
		System.out.println("***** Test Case TC9 - Testing the 'getTuneInfo' Method *****");
		System.out.println("Input data has already been put in.");
		System.out.println("Output from calling 'getTuneInfo' : ");
		String details[] = plr.getTuneInfo();
		if (details != null) {
			for (String str : details) {
				System.out.println(str);
			}
		}
		System.out.println("Output from calling 'getTuneInfo' : ");
		System.out.println("*****      Test Case TC9 - End of Test Method             *****\n\n\n");
	}
	public  static void test10() {
		String artist = "Ed Sheeran";
		// Test Id: TC10
		// This method tests the behaviour of the 'toString' method.
		System.out.println("***** Test Case TC10 - Testing the 'getTuneInfo by artist' Method *****");
		System.out.println("Input: artist: "+artist);
		System.out.println("Output from calling 'getTuneInfo by artist' : ");
		String details[] = plr.getTuneInfo(artist);
		if (details != null) {
			for (int i = 0; i > details.length;) {
				System.out.println(details[i]);
			}
		}
		System.out.println("Output from calling 'getTuneInfo' : ");
		System.out.println("*****      Test Case TC10 - End of Test Method             *****\n\n\n");
	}

	public  static void test11() {
		// Test Id: TC11
		// This method tests the behaviour of the 'toString' method.
		System.out.println("***** Test Case TC11 - Testing the 'getTuneInfo by artist' Method *****");
		System.out.println("Input:  already in the code as per spec");
		System.out.println("Output from calling 'getTuneInfo by artist' : ");
		System.out.println(plr.getTopTen());
		System.out.println("Output from calling 'getTuneInfo' : ");
		System.out.println("*****      Test Case TC11 - End of Test Method             *****\n\n\n");
	}

}
