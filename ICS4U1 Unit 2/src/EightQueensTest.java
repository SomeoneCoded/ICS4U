import java.util.*;

// https://www.geeksforgeeks.org/8-queen-problem/
// only can find one solution
//This class is used to solve the Eight Queens problem. It uses ‘Recursive Backtracking’
//in an attempt to place all the Queens on the board without any 'collisions'
public class EightQueensTest {

	// Global variables (fields)
	private final static int N = 8; // number of queens
	private static int count; // track number of solutions
	private static int[] queenRow = new int[N]; // track row where queen is placed in each column

	// This method runs the program by finding a row to place a queen in the first
	// column (0)
	public static void main(String[] args) {
		findRow(0);
	}

	/***********************************************************************
	 * Try all permutations using recursive backtracking, If you get to the last
	 * column then you have a solution - print it. Otherwise, try the rows one at a
	 * time and if you find a valid spot ask the next column to repeat this process.
	 ***********************************************************************/
	private static void findRow(int n) {
		// if we reached last column
		if (n == N)
			printQueens();

		else {// Traverse through each row in the column
			for (int row = 0; row <= N - 1; row++) {
				// in column N, set the row position of the Queen
				queenRow[n] = row;

				// check if anything is there
				if (isValid(n))
					findRow(n + 1);
			}

		}
	}

	/***********************************************************************
	 * Return true if the current queen placement does not 'conflict' with other
	 * 'prior' placed queens
	 ***********************************************************************/
	private static boolean isValid(int n) {

		// check if we are on the same row
		for (int column = 0; column < n; column++) {

			// check same row
			if (queenRow[column] == queenRow[n])
				return false;

			// check same diagonal (squares)
			if (Math.abs(queenRow[column] - queenRow[n]) == (n - column))
				return false;
		}

		return true;
	}

	/***********************************************************************
	 * Print out an N-by-N display of the board
	 ***********************************************************************/
	private static void printQueens() {

		System.out.printf("Solution %d\n", ++count);

		for (int i = 0; i < N; i++) {
			System.out.print(queenRow[i] + " ");
		}

		System.out.println();

		for (int rows = 0; rows < N; rows++) {
			for (int rowPosition : queenRow) {
				if (rowPosition == rows)
					System.out.print("Q ");
				else
					System.out.print("* ");

			}
			System.out.println();
		}

		System.out.println();

	}

}// end of class
