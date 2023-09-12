package MorrisLab15;

import java.util.ArrayList;

public class Art {
	private String name;
	private String artist;
	ArrayList<String> tags;
	
	public Art(String a, String b) {
		name = a;
		artist = b;
		tags = new ArrayList<String>();
	}
	
	public void addTag(String s) {
		tags.add(s);
	}
	
	public boolean matches(String s) {
		return tags.contains(s);
	}
	
	public String getName() {
		return name;
	}
	public String getArtist() {
		return artist;
	}
	
	
	
}
