package edu.du.cs.cmorris.assignment1;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Grammar {

	private RandomAccessFile raf;
	private Map<NonTerminal, Rule> ruleMap;
	private NonTerminal start;

	public Grammar(String txt) {
		try {
			this.raf = new RandomAccessFile(txt, "r");
			// this.scanner = new Scanner(txt);
			this.ruleMap = new HashMap<NonTerminal, Rule>();

			while (raf.getFilePointer() < raf.length()) {
				String temp = raf.readLine();
				NonTerminal currentNT = new NonTerminal(temp);
				// add rules
				Rule currentRule = new Rule(currentNT);
				temp = raf.readLine();

//			

				while (temp != "") {
					// raf.seek(raf.getFilePointer() - 1);

					if (ruleMap.isEmpty()) {
						start = currentNT;
					}
					// add productions
					currentRule.addP(new Production(temp));
					temp = raf.readLine();

				}
				// ruleMap
				ruleMap.put(currentNT, currentRule);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// System.out.println(ruleMap);
		System.out.println(ruleMap);

	}

	public String generateSentence() {

		String result = "";
		Rule startRule = ruleMap.get(start);

		Stack<Symbol> stack = new Stack<Symbol>();

		Queue<Symbol> startQueue = startRule.getProduction().getQueue();

		stack = createStack(startQueue, stack);

		Stack<Symbol> stack2 = new Stack<Symbol>();
		
		System.out.println(stack);

		while (!stack.isEmpty()) {

			Symbol symbol = stack.pop();

			if (symbol.isTerminal()) {
				stack2.push(symbol);
			} else {
				stack2 = createStack(ruleMap.get(symbol).getProduction().getQueue(), stack2);
			}

		}
		System.out.println(ruleMap.get(start));
		System.out.println(stack2);

		return result;

	}

	public static Stack<Symbol> createStack(Queue<Symbol> queue, Stack<Symbol> stack) {
		Stack<Symbol> tempStack = new Stack<Symbol>();
		for (int i = queue.size() - 1; i >= 0; i--) {

			Symbol temp = queue.remove();

			tempStack.push(temp);

		}
		while (!tempStack.empty()) {
			stack.add(tempStack.pop());
		}
		
		return stack;

	}
}