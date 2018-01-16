package chapter1;

import java.util.ArrayList;

public class ValuePass {
	public static void main(String[] args) {
		System.out.println(ln(3));
	}

	public static void AddOne(int[] array) {

		for (int i = 0; i < array.length; i++)
			array[i] += 1;
	}

	public static void AddOne(ArrayList<Integer> list) {

		for (int i = 0; i < list.size(); i++)
			list.set(i, list.get(i) + 1);
	}

	/**
	 * Print the binary code for a positive int number
	 * 
	 * @param number
	 * @return
	 */
	public static String Integer2BinaryString(int number) {
		if (number <= 0)
			throw new RuntimeException("The input should be positive integer number.");
		String s = "";
		while (number > 0) {
			s = number % 2 + s;
			number /= 2;
		}
		return s;
	}

	/**
	 * Print the transpose matrix given a row * col matrix
	 * 
	 * @param row
	 * @param col
	 */
	public static void MatrixTranspose(int row, int col) {
		int[][] matrix = new int[row][col];
		System.out.println("Before Transpose: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = i + j;
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		int[][] matrix_t = new int[col][row];
		System.out.println("Before Transpose: ");
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				matrix_t[i][j] = matrix[j][i];
				System.out.print(matrix_t[i][j] + "\t");
			}
			System.out.println();
		}

	}

	/**
	 * Without using standard Math library, print the max int which is not larger
	 * than the given int number
	 * 
	 * @param number
	 */
	public static void lg(int number) {
		if (number <= 0)
			throw new RuntimeException("The input should be postive int numbers");
		int i = 0;
		while (i * i <= number)
			i++;
		System.out.println(i - 1);
	}

	/**
	 * Calculate log(N!) in a recurisive fashion
	 * 
	 * @param number
	 * @return
	 */
	public static double ln(int number) {
		if (number == 1)
			return Math.log(number);
		return Math.log(number) + ln(number - 1);
	}
}
