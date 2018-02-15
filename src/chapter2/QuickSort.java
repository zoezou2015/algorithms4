package chapter2;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {
	public static void sort(Comparable[] a) {
		shuffleArray(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int low, int high) {
		if (high <= low)
			return;
		int j = partition(a, low, high);
		sort(a, low, j - 1);
		sort(a, j + 1, high);
	}

	public static int partition(Comparable[] a, int low, int high) {
		int i = low, j = high + 1;
		Comparable v = a[low];
		while (true) {
			while (less(a[++i], v))
				if (i == high)
					break;
			while (less(v, a[--j]))
				if (j == low)
					break;
			if (i >= j)
				break;
			exch(a, i, j);
		}
		exch(a, low, j);
		return j;
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

	private static void shuffleArray(Comparable[] array) {
		// If running on Java 6 or older, use `new Random()` on RHS here
		Random rnd = ThreadLocalRandom.current();
		for (int i = array.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			// Simple swap
			Comparable a = array[index];
			array[index] = array[i];
			array[i] = a;
		}
	}
}
