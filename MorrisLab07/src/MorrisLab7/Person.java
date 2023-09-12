package MorrisLab7;

public class Person {
	private String name;

	public Person() {
		this.name = "No Name";
	}

	public Person(String n) {
		if (n != null) {
			this.name = n;
		} else {
			this.name = "No name";
		}
	}

	public void setName(String n) {
		if (n != null) {
			this.name = n;
		} else {
			System.out.println("Fatal error in Person class - attempt to set name to a null String");
			System.exit(0);
		}
	}

	public String toString() {
		return "Name: " + this.name;
	}
	
	public void deepCopy(Person P) {
		this.name = P.name;
	}
	
	public boolean equals(Person P) {
		return P.name.equals(name);
	}
}