package chapter1;

public class FixedCapacityStack<Item> {

	private Item[] stack;
	private int N;
	private int cap;

	public FixedCapacityStack(int cap) {
		this.cap = cap;
		stack = (Item[]) new Object[cap];
	}

	public void push(Item item) {
		if (this.N <= this.cap) {
			stack[++N] = item;
		} else {
			throw new RuntimeException();
		}
	}

	public Item pop() {
		if (this.N > 0) {
			return this.stack[--this.N];
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
}
