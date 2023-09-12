package edu.du.cs.cmorris.assignment1;

public interface Symbol {
	
	public String toString();
	public boolean equals(Object o);
	public int compareTo();
	public boolean isTerminal();
	public String getSymbol();
	

}
