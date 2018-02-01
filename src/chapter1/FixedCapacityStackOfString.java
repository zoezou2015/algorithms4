/**
 * A stack class in a fixed capacity but only for String 
 * 
 **/
package chapter1;

public class FixedCapacityStackOfString {

	private String[] stack;
	// The pointer of the stack
	private int N;
	// The capacity of the stack, i.e., the length of the array
	private int cap;

	public FixedCapacityStackOfString(int cap) {
		this.cap = cap;
		stack = new String[cap];
	}

	public void push(String s) {
		if (this.N <= this.cap)
			stack[this.N++] = s;
		else
			throw new RuntimeException("The stack is full! Pointer is: " + this.N + " of capacity " + this.cap);
	}

	public String pop() {
		if (this.N != 0)
			return stack[--this.N];
		else
			throw new RuntimeException("The stack is null!");
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return this.cap;
	}
}
