package chapter2;

public class MaxPriorityQueue<Key extends Comparable<Key>> {

	private Key[] pq;
	private int N = 0;

	public MaxPriorityQueue() {

	}

	public MaxPriorityQueue(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];

	}

	public MaxPriorityQueue(Key[] a) {

	}

	public void Insert(Key v) {
		pq[++N] = v;
		swim(N);
	}

	public Key max() {
		if (isEmpty())
			return null;
		return pq[1];
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		return max;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(k, j);
			k = j;
		}
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k /= 2;
		}
	}

	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}
}
