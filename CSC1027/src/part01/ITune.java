package part01;

public interface ITune {
	public String toString();
	public String getTitle();
	public String getArtist();
	public int getDuration();
	public String getStyle();
	public int getPlayCount();
	public String play();
}
