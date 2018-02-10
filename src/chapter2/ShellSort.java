package chapter2;

public class ShellSort {

	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j > 0 && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
	}

	/**
	 * Exchange the two element in the array "a"
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable a_i = a[i];
		Comparable a_j = a[j];
		Comparable temp = a_i;
		a_i = a_j;
		a_j = a_i;
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
