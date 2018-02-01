/**
 * A stack class in a fixed capacity but applicable to any object types
 * 
 **/
package chapter1;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item> {

	private Item[] stack;
	private int N;
	private int cap;

	public FixedCapacityStack(int cap) {
		this.cap = cap;
		stack = (Item[]) new Object[cap];
	}

	public void push(Item item) {
		if (this.N <= this.cap) {
			if (this.N == this.cap)
				resize(2 * this.cap);
			stack[++N] = item;
		} else {
			throw new RuntimeException();
		}
	}

	public Item pop() {
		if (this.N > 0) {
			Item item = this.stack[--this.N];
			this.stack[N] = null;
			if (this.N > 0 && this.N == this.cap / 4)
				resize(this.cap / 2);
			return item;
		} else {
			throw new RuntimeException();
		}
	}

	public int Size() {
		return this.N;
	}

	public boolean isEmpty() {
		return this.N == 0;
	}

	public void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < this.N; i++)
			temp[i] = this.stack[i];
		this.stack = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();

	}

	public class ReverseArrayIterator implements Iterator<Item> {
		private int i = N;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Item next() {
			return stack[--i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
