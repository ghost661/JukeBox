package part03;

import part01.Genre;
import part01.Tune;

public class testTune {

	// Test Data 1 ================================
	static String tuneTitle1 = "Old MacDonald";// =
	static String tuneArtist1 = "Ronald";      // =
	static int tuneDuration1 = 2;              // =
	static Genre tuneStyle1 = Genre.ROCK;      // =
	// ============================================

	// Test Data 2 ===============================================
	static String tuneTitle2 = "Twinkle Twinkle Little Star.";// =
	static String tuneArtist2 = "Jane Taylor";                // =
	static int tuneDuration2 = 1;                             // =
	static Genre tuneStyle2 = Genre.CLASSICAL;                // =
	// ===========================================================

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		}
	
	


	public static void test1() {
		// Test Id: TC1
		// This method tests the behaviour of the 'toString' method.
		Tune testTune1 = new Tune(tuneTitle1, tuneArtist1, tuneDuration1, tuneStyle1);
		System.out.println("***** Test Case TC1 - Testing the 'toString' Method *****");
		System.out.println("Input Data: Title: " + tuneTitle1 + ", Artist: " + tuneArtist1 + ", Duration: "
				+ tuneDuration1 + ", Style: " + tuneStyle1);
		String result = testTune1.toString();
		System.out.println("Output from calling 'statement' : ");
		System.out.println(result);
		System.out.println("*****      Test Case TC1 - End of Test Method             *****\n\n\n");
	}

	public static void test2() {
		// Test Id: TC2
		// This method tests the behaviour of the 'Incrementation of the Id' method.
		Tune testTune1 = new Tune(tuneTitle1, tuneArtist1, tuneDuration1, tuneStyle1);
		Tune testTune2 = new Tune(tuneTitle2, tuneArtist2, tuneDuration2, tuneStyle2);
		System.out.println("***** Test Case TC2 - Testing the 'Incrementation of the Id' Method *****");
		System.out.println("Input Data: Title: " + tuneTitle2 + ", Artist: " + tuneArtist2 + ", Duration: "
				+ tuneDuration2 + ", Style: " + tuneStyle2);
		testTune1.toString();
		String result = testTune2.toString();
		System.out.println("Output from calling 'statement' : ");
		System.out.println(result);
		System.out.println("*****      Test Case TC2 - End of Test Method             *****\n");
	}

	public static void test3() {
		// Test Id: TC3
		// This method tests the behaviour of the 'Play' method.
		Tune testTune1 = new Tune(tuneTitle1, tuneArtist1, tuneDuration1, tuneStyle1);
		System.out.println("***** Test Case TC3 - Testing the 'toString' Method *****");
		System.out.println("Input Data: Title: " + tuneTitle1 + ", Artist: " + tuneArtist1 + ", Duration: "
				+ tuneDuration1 + ", Style: " + tuneStyle1);
		String result = testTune1.play();
		System.out.println("Output from calling 'statement' : ");
		System.out.println(result);
		System.out.println("*****      Test Case TC3 - End of Test Method             *****\n\n\n");

	}
	public static void test4() {
		// Test Id: TC4
		// This method tests the behaviour of the 'playCount' method.
		Tune testTune1 = new Tune(tuneTitle1, tuneArtist1, tuneDuration1, tuneStyle1);
		System.out.println("***** Test Case TC4 - Testing the 'toString' Method *****");
		System.out.println("Input Data: Title: " + tuneTitle1 + ", Artist: " + tuneArtist1 + ", Duration: "
				+ tuneDuration1 + ", Style: " + tuneStyle1);
		System.out.println("Output from calling 'statement' : ");
		String result1 = testTune1.toString();
		System.out.println(result1+"<= this result for play count");
		testTune1.play();
		String result2 = testTune1.toString();
		System.out.println(result2+"<= this result for play count");
		System.out.println("*****      Test Case TC1 - End of Test Method             *****\n\n\n");
	}
	
	
	public static void test5() {
		String inputTitle = "barny is a dinasour";
		// Test Id: TC5
		// This method tests the behaviour of the 'toString' method.
		Tune testTune1 = new Tune(tuneTitle1, tuneArtist1, tuneDuration1, tuneStyle1);
		System.out.println("***** Test Case TC5 - Testing the 'setTitle' Method *****");
		System.out.println("Input Data:All of test Data Title: " +  inputTitle);
		String PreCondition = testTune1.toString();
		System.out.println(PreCondition);
		testTune1.setTitle(inputTitle);
		System.out.println("Output from calling 'setTitle' : ");
		String result = testTune1.toString();
		System.out.println(result);
		System.out.println("*****      Test Case TC1 - End of Test Method             *****\n\n\n");
	}
	public static void test6() {
		String inputArtist = "barny ";
		// Test Id: TC6
		// This method tests the behaviour of the 'toString' method.
		Tune testTune1 = new Tune(tuneTitle1, tuneArtist1, tuneDuration1, tuneStyle1);
		System.out.println("***** Test Case TC6 - Testing the 'setArtist' Method *****");
		System.out.println("Input Data:All of test Data, Artist: " +  inputArtist);
		String PreCondition = testTune1.toString();
		System.out.println(PreCondition);
		testTune1.setArtist(inputArtist);
		System.out.println("Output from calling 'setTitle' : ");
		String result = testTune1.toString();
		System.out.println(result);
		System.out.println("*****      Test Case TC6 - End of Test Method             *****\n\n\n");
	}
	
	}


