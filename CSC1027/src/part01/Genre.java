package part01;

public enum Genre {
	ROCK("Rock and Roll"),
	POP("Easy Listening Pop"),
	DANCE("Techno Dance"),
	JAZZ("Smooth Jazz"),
	CLASSICAL("Classical"),
	OTHER ("Unknown Genre");
	private String str;
	
	private Genre (String genre) {
		str=genre;
	}
	public String toString() {
		return str;
	}


}
