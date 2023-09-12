package edu.du.cs.cmorris.assignment1;

import java.util.*;

public class Rule {

	//instance variables
	private NonTerminal key;
	private List<Production> productions;
	
	//constructor
	public Rule(NonTerminal k) {
		this.key = k;
		this.productions = new ArrayList<Production>();
	}
	
	public void addP(Production p) {
		productions.add(p);
	}
	
	public String toString() {
		return productions.toString() + "\n";
	}
	
	public Production getProduction(){
		return productions.get(0);
		
		//randomizer goes here
	}
	
}