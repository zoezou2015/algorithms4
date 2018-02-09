/**
 * Implementation of selection sort algorithm
 * 
 */
package chapter2;

public class SelectionSort {

	public void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
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
