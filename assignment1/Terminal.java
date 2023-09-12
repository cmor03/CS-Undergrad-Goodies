package edu.du.cs.cmorris.assignment1;

public class Terminal implements Symbol {

	private String symbol;

	public Terminal(String s) {
		this.symbol = s;
	}

	@Override
	public boolean equals(Object o) {
		return (symbol.equals(((Terminal) o).getSymbol()));
	}

	@Override
	public int compareTo() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String toString() {
		if (symbol == "") {
			return null;
		}
		return symbol;
	}

	public boolean isTerminal() {
		return true;
	}

	@Override
	public int hashCode() {
		return (int) symbol.hashCode();

	}

	public String getSymbol() {
		return symbol;

	}

}
