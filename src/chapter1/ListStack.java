/**
 * Implement a stack class using list
 * **/
package chapter1;

import java.util.Iterator;

public class ListStack<Item> implements Iterable<Item> {

	Node first;
	int N;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public int size() {
		return this.N;
	}

	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		this.N++;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		this.N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {

		private Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = first.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
