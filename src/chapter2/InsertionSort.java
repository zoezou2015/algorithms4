package chapter2;

public class InsertionSort {

	public static void sort(Comparable[] a) {
		if (isSorted(a))
			return;
		for (int i = 1; i < a.length; i++) {
			for (int pointer = i; pointer > 0 && less(a[pointer], a[pointer - 1]); pointer--) {
				exch(a, pointer, pointer - 1);
			}
		}

	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable a_i = a[i];
		Comparable a_j = a[j];
		Comparable temp = a_i;
		a_i = a_j;
		a_j = temp;
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

	private static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (less(a[i + 1], a[i]))
				return false;
		}
		return true;
	}

}
