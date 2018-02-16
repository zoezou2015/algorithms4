package chapter3;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] values;
	private int N;

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		values = (Value[]) new Object[capacity];
		N = 0;
	}

	public void put(Key key, Value val) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			values[i] = val;
			return;
		}
		for (int j = N; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = val;
		N++;
	}

	public Value get(Key key) {
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0)
			return values[i];
		else
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
		return N;
	}

	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[N - 1];
	}

	public Key floor(Key key) {
		return null;
	}

	public Key ceiling(Key key) {
		int i = rank(key);
		return keys[i];
	}

	public Key select(int k) {
		return keys[k];
	}

	public int rank(Key key) {
		int low = 0, high = N - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0)
				high = mid - 1;
			else if (cmp > 0)
				low = mid + 1;
			else
				return mid;
		}
		return low;
	}

	public void deleteMin() {

	}

	public void deleteMax() {

	}

	public int size(Key low, Key high) {
		return -1;
	}

	public Iterable<Key> keys(Key low, Key high) {
		// Queue<Key> queue = new Queue<Key>();
		// for (int i = rank(low); i < rank(high); i++) {
		// queue.add(keys[i]);
		// if (contains(high)) {
		// queue.add(keys[rank(high)]);
		// }
		// }
		// return queue;
		return null;
	}

	public Iterable<Key> keys() {
		return null;
	}
}
