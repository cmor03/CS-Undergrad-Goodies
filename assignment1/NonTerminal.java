package edu.du.cs.cmorris.assignment1;

public class NonTerminal implements Symbol {

	private String symbol;

	public NonTerminal(String s) {
		this.symbol = s;
	}

	@Override
	public boolean equals(Object o) {
		
		return (symbol.equals(((NonTerminal) o).getSymbol()));
	}

	@Override
	public int compareTo() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		return symbol;
	}

	public boolean isTerminal() {
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int)symbol.hashCode();
		
	}
	
	public String getSymbol() {
		return symbol;
	}

}
