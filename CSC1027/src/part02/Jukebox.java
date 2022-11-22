package part02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import part01.Genre;

public class Jukebox extends part01.MP3Player { // look at inheritance
	private int moneyAdded; // this is the varible of how the money is counted
	private int costPerPlay;// this is a varaible that is used to to charge the user of the jukebox
	private static String path = "tune.csv";
	private boolean header = true;

	/**
	 * constructor – parameters: monneyAdded
	 */
	public Jukebox() {
		this.costPerPlay=10;
		this.moneyAdded=0;
		readAllOfCsv();
		loadCostPerPlay();
	}

//-----------Getters

	public int getCostPerPlay() {
		return this.costPerPlay;
	}

	public int getMoneyAdded() {
		return this.moneyAdded;
	}

	public String[] getTuneInfo() {
		String[] str = super.getTuneInfo();
		return str;
	}

	public String[] getTuneInfo(String artist) {
		String[] str = super.getTuneInfo(artist);
		return str;
	}

// ============Setters
	public void setCostPerPlayBase(int cost) {
		this.costPerPlay = cost;
	}

	public String setCostPerPlay(int cost) {
		setCostPerPlayBase(cost);
		refreshHeader();
		refreshData();
		return "cost per play has be edited to " + cost;
	}

	public void setMoneyAdded(int moneyToAdd) {
		this.moneyAdded += moneyToAdd;
	}

//--------------Header and CostPerPlay  for CSV
	public void refreshHeader() {
		try {
			String myDir = path;
			FileWriter myFw = new FileWriter(myDir);
			PrintWriter myPw = new PrintWriter(myFw);
			myPw.println("Title, Artist, Duration, Genre," + getCostPerPlay());
			myPw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void refreshData() {
		String[] str = getTuneInfo();
		if (str.length > 0) {
			for (int i = 0; i < str.length;) {
				String record = str[i];
				String[] tune = record.split(",");
				String title = tune[1].trim();
				String artist = tune[2].trim();
				int duration = Integer.parseInt(tune[3].trim());
				Genre style = selectGenre(tune[4].trim());
				// Add a new MotTestCentre to the array list to be returned.
				addTune(title, artist, duration, style);
				i++;
			}

		}
	}

	public void loadCostPerPlay() {
		try {
			File myFile = new File(path);
			Scanner mySc = new Scanner(myFile);
			String record = mySc.nextLine();
			String[] tune = record.split(",");
			int Cost = Integer.parseInt(tune[4].trim());
			setCostPerPlayBase(Cost);
			mySc.close();
		} catch (FileNotFoundException e) {
			refreshHeader();

			e.printStackTrace();
		}

	}

// -------------User funcanality
	public String insertCoin(int coin) {
		String statement = "";
		int[] ref = new int[] { 10, 20, 50, 100, 200 };
		for (int i = 0; i < ref.length;) {
			if (ref[i++] == coin) {
				setMoneyAdded(coin);
				statement = "Coin accepted,\nyou now have " + getMoneyAdded() + " pence in the jukebox";
				return statement;
			}
		}
		statement = "Coin not accepted,\n please try again";
		return statement;
	}

	@Override
	public String playTune(int tuneId) {
		int moneyAdded = getMoneyAdded();
		int Cost = getCostPerPlay();
		if (moneyAdded >= Cost) {
			setMoneyAdded(moneyAdded - Cost);
			return super.playTune(tuneId);

		} else {
			String str = ("Please add more money as currently " + moneyAdded + " pence, to play a tune you need "
					+ Cost);
			return str;
		}
	}

//======================Genre 

	public Genre selectGenre(String check) {
		if (check.equalsIgnoreCase("Rock and Roll")) {
			return Genre.ROCK;
		} else if (check.equalsIgnoreCase("Easy Listening Pop")) {
			return Genre.POP;
		} else if (check.equalsIgnoreCase("Techno Dance")) {
			return Genre.DANCE;
		} else if (check.equalsIgnoreCase("Smooth Jazz")) {
			return Genre.JAZZ;
		} else if (check.equalsIgnoreCase("Classical")) {
			return Genre.CLASSICAL;
		} else {
			return Genre.OTHER;
		}
	}

// =========================

	public void readAllOfCsv() {
		try {
			File myFile = new File(path);
			Scanner mySc = new Scanner(myFile);
			if (header) {
				mySc.nextLine();

			}
			if (mySc.hasNextLine() == false) {
			}
			while (mySc.hasNextLine()) {
				String record = mySc.nextLine();
				String[] tune = record.split(",");
				String title = tune[0].trim();
				String artist = tune[1].trim();
				int duration = Integer.parseInt(tune[2].trim());
				Genre style = selectGenre(tune[3].trim());
				// Add a new MotTestCentre to the array list to be returned.
				super.addTune(title, artist, duration, style);
			}
			mySc.close();
		} catch (FileNotFoundException e) {
			refreshHeader();

			e.printStackTrace();
			// A null object is returned in the event of any errors.
		}
	}

	public boolean addToCsv(String title, String artist, int duration, Genre style) {
		try {
			File myFile = new File(path);
			Scanner mySc = new Scanner(myFile);
			if (header) {
				mySc.nextLine();
			}
			while (mySc.hasNextLine()) {
				String record = mySc.nextLine();
				String[] tune = record.split(",");

				String searchTitle = tune[0].trim();
				String searchArtist = tune[1].trim();
				if ((searchTitle.equals(title)) && (searchArtist.equals(artist))) {
					mySc.close();
					return false;
				}

			}
			mySc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// A null object is returned in the event of any errors.
		}

		try {
			String myDir = path;
			FileWriter myFw = new FileWriter(myDir, true);
			PrintWriter myPw = new PrintWriter(myFw);
			myPw.print(title + ", ");
			myPw.print(artist + ", ");
			myPw.print(duration + ", ");
			myPw.print(style + "\n");
			myPw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean addTune(String title, String artist, int duration, Genre style) {
		boolean confirm = addToCsv(title, artist, duration, style);
		if (confirm == true) {
			super.addTune(path, path, costPerPlay, null);
			return true;
		}
		return false;
	}

}
