/**
 * Implement bag using list
 */
package chapter1;

import java.util.Iterator;

public class ListBag<Item> implements Iterable<Item> {

	private Node first;
	private int N;

	public int size() {
		return this.N;
	}

	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		this.N++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new BagIterator();
	}

	private class Node {
		Item item;
		Node next;
	}

	private class BagIterator implements Iterator<Item> {
		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}
}
