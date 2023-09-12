package edu.du.cs.cmorris.lab1;

public class Song implements Comparable {

	private String title;
	private Artist artist;
	private int runningTime; // in sec

	public Song(String t, Artist artist, int runTime) {
		this.title = t;
		this.artist = artist;
		this.runningTime = runTime;

	}

	public String toString() {

		return title + " (" + runningTime + ") " + artist;
	}

	@Override
	public boolean equals(Object o) {
		Song s = (Song) o;
		return (title.equals(s.title) && artist.equals(s.artist) && runningTime == s.runningTime);

	}

	public int getTime() {
		return runningTime;
	}

	@Override
	public int compareTo(Object o) {

		Song s = (Song) o;

		if (title.compareTo(s.title) > 0) {
			return 1;
		} else if (title.compareTo(s.title) < 0) {
			return -1;
		} else {

			if (artist.compareTo(s.artist) > 0) {
				return 1;
			} else if (artist.compareTo(s.artist) < 0) {
				return -1;
			} else if (artist.compareTo(s.artist) == 0) {
				return runningTime - s.runningTime;
			} else

				return 0;
		}

		/*
		 * first, do song title, then do artist(), then do song length.
		 */

	}

}
