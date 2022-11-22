package part01;

public interface IPlayer {
	public String playTune(int tuneId);
	public String[] getTuneInfo();
	public String[] getTuneInfo(String artist);
	public boolean addTune(String title, String artist, int duration, Genre style);
	public String getTopTen();
}
