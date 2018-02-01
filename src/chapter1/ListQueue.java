/**
 * Implement a queue using list
 */
package chapter1;

import java.util.Iterator;

public class ListQueue<Item> implements Iterable<Item> {
	private Node head;
	private Node tail;
	private int N = 0;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public int size() {
		return this.N;
	}

	public void enQueue(Item item) {
		Node oldTail = this.tail;
		this.tail = new Node();
		this.tail.item = item;
		this.tail.next = null;
		if (isEmpty()) {
			this.head = this.tail;
		} else {
			oldTail.next = this.tail;
		}
		this.N++;
	}

	public Item deQueue() {
		Item item = this.head.item;
		Node headNext = this.head.next;
		this.head = headNext;
		if (isEmpty())
			this.tail = null;
		this.N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {
		Node currentHead = head;

		@Override
		public boolean hasNext() {
			return head != null;
		}

		@Override
		public Item next() {
			Item item = currentHead.item;
			currentHead = currentHead.next;
			return item;
		}

	}
}
