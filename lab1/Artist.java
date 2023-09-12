package edu.du.cs.cmorris.lab1;

public class Artist {

	private String lastName;
	private String firstName;

	public Artist(String lName, String fName) {
		this.lastName = lName;
		this.firstName = fName;
	}

	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public boolean equals(Object e) {
		Artist a = (Artist) e;
		return a.firstName.equals(firstName) && a.lastName.equals(lastName);
	}

	// needs a compare to for artist
	public int compareTo(Object o) {
		Artist a = (Artist)o;
		
		if (lastName.compareTo(a.lastName) >0) {
			return 1;
		}
		
		else if (lastName.compareTo(a.lastName)<0) {
			return -1;
		}
		
		else {
			if (firstName.compareTo(a.firstName) >0){
				return 1;
			}
			else if (firstName.compareTo(a.firstName) <0) {
				return -1;
			}
			
			else 
				return 0;
		}
	}

}
