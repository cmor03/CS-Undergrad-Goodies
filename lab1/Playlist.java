package edu.du.cs.cmorris.lab1;

import java.util.*;

public class Playlist{
	
	private String name;
	private List<Song> songs;
	
	public Playlist(String n) {
		this.name = n;
		songs = new ArrayList<Song>();
	}
	
	public void addSong(Song n) {
		songs.add(n);
	}
	
	public String toString() {
		String result = name + " [";
		
		for (int i = 0; i < songs.size() -1 ; i++) {
			result += songs.get(i).toString() +", ";
		}
		
		result += songs.get(songs.size()-1).toString() + "]";
		
		return result;
	}
	
	public boolean contains(Song o){
		return songs.contains(o);
		
	}

	public int runningTime() {
		int total = 0;
		for (int i = 0; i < songs.size() ; i++) {
			total += songs.get(i).getTime();
		}
		return total;
	}
	
	@SuppressWarnings("unchecked")
	public void sortBySong() {
		Collections.sort(songs);
		
	}
	

}
