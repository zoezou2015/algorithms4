package chapter3;

public class SequentialSearchST<Key extends Comparable<Key>, Value> {

	private Node first;

	private class Node {
		private Key key;
		private Value value;
		private Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public void put(Key key, Value val) {
		Node x = first;
		for (; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.value = val;
				return;
			}
		}
		first = new Node(key, val, first);
	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x))
				return x.value;
		}
		return null;
	}

	public void delete(Key key) {

	}

	public boolean contains(Key key) {
		return false;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return 0;
	}

	public Key min() {
		return null;
	}

	public Key max() {
		return null;
	}

	public Key floor(Key key) {
		return null;
	}

	public Key ceiling(Key key) {
		return null;
	}

	public Key select(int k) {
		return null;
	}

	public int rank(Key key) {
		return 0;
	}

	public void deleteMin() {

	}

	public void deleteMax() {

	}

	public int size(Key low, Key high) {
		return -1;
	}

	public Iterable<Key> keys(Key low, Key high) {
		return null;
	}

	public Iterable<Key> keys() {
		return null;
	}
}
