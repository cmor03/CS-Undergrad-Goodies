
package edu.du.cs.cmorris.assignment1;
import java.util.*;

public class Production {
	
	private String p;
	private Queue<Symbol> symbols;

	public Production(String s) {
		this.p = s;
		this.symbols = new LinkedList<Symbol>();
		
		
		//split string
		String[] splitS = p.split(" ");
		//String newString = "";
		
		for(int i = 0; i < splitS.length; i ++) {
			//if nonterminal
			
			if (splitS[i].length()>0) {
				if(splitS[i].charAt(0) == '<') {
					//new nonterminal symbol
					symbols.add(new NonTerminal(splitS[i]));
				} else { // else its terminal
					//new terminal symbol
					symbols.add(new Terminal(splitS[i]));
				}
			}
			
		}
	
	}
	
	public String toString() {
		return "Production: " + p + " " + symbols.toString();
	}
	
	public Queue<Symbol> getQueue(){
		return symbols;
	}
	
}