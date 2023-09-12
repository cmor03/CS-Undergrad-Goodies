package edu.du.cs.cmorris.bstStarting;

import java.util.LinkedList;

import java.util.Queue;

// Binary Search Tree implementation
public class BST<T extends Comparable<T>> {

	// Nested class to hold tree nodes
	class TNode {
		private T nodeValue;
		private TNode left;
		private TNode right;
		private TNode parent;

		public TNode(T item) {
			nodeValue = item;
			left = null;
			right = null;
			parent = null;
		}

		public String toString() {
			return nodeValue.toString();
		}
	}

	private TNode root;

	// Construct an empty BST
	public BST() {
		root = null;
	}

	public void delete(T t) {

		TNode removeN = findNode(t);

		// case for if there are no children
		if (removeN.left == null && removeN.right == null) {
			if (removeN.parent.left.nodeValue == removeN.nodeValue) {
				removeN.parent.left = null;
			} else {
				removeN.parent.right = null;
			}
			// case for if there is one child
		} else if (removeN.left == null) {
			removeN.parent.right = removeN.right;

		} else if (removeN.right == null) {
			removeN.parent.left = removeN.left;
		} else {
			TNode temp = removeN.left;

			if (temp.right == null) {
				temp.right = removeN.right;
				removeN.parent.left = temp;

			} else {
				boolean end = false;

				while (!end) {
					if (temp.right != null) {
						temp = temp.right;
					} else {
						end = !end;
					}

				}
				T val = temp.nodeValue;
				delete(temp.nodeValue);
				removeN.nodeValue = val;

			}

			// since there are two children, just pick either child

			// if the child has only one child, pick that one

			// if the child has two children, pick left

			// if you can't pick left

			// then just search through that for the lowest value

		}
	}

	public TNode findNode(T t) {
		TNode target = null;
		TNode current = root;

		// Keep going until we reach the end of the tree (null) or
		// until we find a node that is equal to the target
		while ((current != null) && (!current.nodeValue.equals(t))) {

			if (current.nodeValue.compareTo(t) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (current == null) {

		} else {
			target = current;
		}

		return target;

	}

	public boolean contains(T t) {
		boolean result;

		// Start at the root
		TNode current = root;

		// Keep going until we reach the end of the tree (null) or
		// until we find a node that is equal to the target
		while ((current != null) && (!current.nodeValue.equals(t))) {

			if (current.nodeValue.compareTo(t) > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (current == null) {
			result = false;
		} else {
			result = true;
		}

		return result;
	}

	public void insert(T t) {
		TNode newNode = new TNode(t);

		if (root == null) {
			root = newNode;
		} else {
			TNode current = root;
			boolean done = false;
			while (!done) {

				if (current.nodeValue.compareTo(t) > 0) {
					if (current.left == null) {
						current.left = newNode;
						newNode.parent = current;
						done = true;
					} else {
						current = current.left;
					}

				} else {
					if (current.right == null) {
						current.right = newNode;
						newNode.parent = current;
						done = true;
					} else {
						current = current.right;
					}
				}
			}
		}
	}

	// This is a debugging utility.
	// It simply displays all the nodes at each level, but doesn't show which ones
	// are corrected to which parents. You will need to use the debugger to inspect
	// that information if needed for debugging.
	public void displayTree() {
		// Doesn't show links between parent and child nodes
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			Queue<TNode> q = new LinkedList<TNode>();
			Queue<Integer> levelQ = new LinkedList<Integer>();
			Queue<Integer> tabQ = new LinkedList<Integer>();
			q.add(root);
			levelQ.add(0);
			tabQ.add(10);
			int currentLevel = 0;
			int currentTab = 0;

			while (!q.isEmpty()) {
				TNode current = q.remove();
				int level = levelQ.remove();
				int tab = tabQ.remove();

				if (currentLevel != level) {
					System.out.print("\n");
					currentLevel++;
					currentTab = 0;

					// Display the connectors....

					// First make a copy of the data
					Queue<TNode> qCopy = new LinkedList<TNode>(q);
					Queue<Integer> levelQCopy = new LinkedList<Integer>(levelQ);
					Queue<Integer> tabQCopy = new LinkedList<Integer>(tabQ);

					// Then run through all the elements until the next level hits
					int currentLevelCopy = currentLevel;
					int currentTabCopy = currentTab;

					TNode currentCopy = current;
					int levelCopy = level;
					int tabCopy = tab;

					while (currentLevelCopy == levelCopy) {
						while (currentTabCopy < tabCopy) {
							System.out.print("   ");
							currentTabCopy++;
						}
						if (currentCopy.parent.left == currentCopy) {
							System.out.print(" /");
						} else {
							System.out.print("\\");
						}

						if (!qCopy.isEmpty()) {
							currentCopy = qCopy.remove();
							levelCopy = levelQCopy.remove();
							tabCopy = tabQCopy.remove();
						} else {
							levelCopy = -1; // We hit the end of the queue before the next level started
						}
					}
					System.out.println("\n");
					// Done displaying connectors

				}
				while (currentTab < tab) {
					System.out.print("   ");
					currentTab++;
				}
				System.out.print(current.nodeValue);

				// if a left child exists, insert it in the queue
				if (current.left != null) {
					q.add(current.left);
					levelQ.add(level + 1);
					tabQ.add(tab - 1);
				}
				// if a right child exists, insert next to its sibling
				if (current.right != null) {
					q.add(current.right);
					levelQ.add(level + 1);
					tabQ.add(tab + 1);
				}
			}
		}
		System.out.print("\n");
	}

}
