package chapter2;

public class MergeSort {

	private static Comparable[] aux;

	public static void TopDownMergeSort(Comparable[] a) {
		aux = new Comparable[a.length];
		TopDownMergeSort(a, 0, a.length - 1);
	}

	private static void TopDownMergeSort(Comparable[] a, int low, int high) {
		if (low >= high)
			return;
		int mid = low + (high - low) / 2;
		TopDownMergeSort(a, low, mid);
		TopDownMergeSort(a, mid + 1, high);
		if (!less(a[mid], a[mid + 1]))
			return;
		merge(a, low, mid, high);
	}

	public static void BottomUpMergeSort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for (int sz = 1; sz < N; sz = sz + sz) {
			for (int low = 0; low < N - sz; low += sz + sz) {
				merge(a, low, low + sz - 1, Math.min(low + sz + sz - 1, N - 1));
			}
		}
	}

	public static void merge(Comparable[] a, int low, int mid, int high) {
		aux = new Comparable[high - low + 1];
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++) {
			aux[k - low] = a[k];
		}
		for (int k = low; k <= high; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > high)
				a[k] = aux[i++];
			else if (less(aux[i], aux[j]))
				a[k] = aux[i++];
			else
				a[k] = aux[j++];

		}
	}

	/**
	 * Returen true it v < w
	 * 
	 * @return
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * Print the array
	 * 
	 * @param a
	 */
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Return false if the given array is not sorted
	 * 
	 * @param a
	 * @return
	 */
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++)
			if (less(a[i], a[i + 1]))
				return false;
		return true;
	}

}
