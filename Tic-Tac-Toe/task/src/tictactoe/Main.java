package tictactoe;

import java.util.Scanner;

public class Main {
	private static final Scanner sc = new Scanner(System.in);
	private static int count = 0;

	public static void main(String[] args) {

		// write your code here
		String cells = "         ";
		drawMatrix(cells);

		while (getResult(cells).equals("Game not finished")) {
			cells = enterCoordinates(cells);
			drawMatrix(cells);
		}

	}

	private static boolean isEmptyCell(String cells, int charIndex) {
		return cells.charAt(charIndex) == ' ' || cells.charAt(charIndex) == '_';
	}

	private static void  coordinateOccupiedMessage() {
		System.out.println("This cell is occupied! Choose another one!");
	}

	private static char nextTurn() {
		return ++count % 2 == 1 ? 'X' : 'O';
	}

	private static String enterCoordinates(String cells) {

		while (true) {
			System.out.print("Enter the coordinates: ");
			String coordinate1 = sc.next();
			String coordinate2 = sc.next();

			if ((coordinate1.length() == 1 && coordinate1.charAt(0) > 48 && coordinate1.charAt(0) < 52) &&
					(coordinate2.length() == 1 && coordinate2.charAt(0) > 48 && coordinate2.charAt(0) < 52)) {

				int c1 = coordinate1.charAt(0) - 48;
				int c2 = coordinate2.charAt(0) - 48;

				if (c2 == 3) {
					if (c1 == 1) {
						if (isEmptyCell(cells, 0)) {
							return nextTurn() + cells.substring(1);
						} else {
							coordinateOccupiedMessage();
						}
					} else if (c1 == 2) {
						if (isEmptyCell(cells, 1)) {
							return cells.substring(0, 1) + nextTurn() + cells.substring(2);
						} else {
							coordinateOccupiedMessage();
						}
					} else if (c1 == 3) {
						if (isEmptyCell(cells, 2)) {
							return cells.substring(0, 2) + nextTurn() + cells.substring(3);
						} else {
							coordinateOccupiedMessage();
						}
					}
				} else if (c2 == 2) {
					if (c1 == 1) {
						if (isEmptyCell(cells, 3)) {
							return cells.substring(0, 3) + nextTurn() + cells.substring(4);
						} else {
							coordinateOccupiedMessage();
						}
					} else if (c1 == 2) {
						if (isEmptyCell(cells, 4)) {
							return cells.substring(0, 4) + nextTurn() + cells.substring(5);
						} else {
							coordinateOccupiedMessage();
						}
					} else if (c1 == 3) {
						if (isEmptyCell(cells, 5)) {
							return cells.substring(0, 5) + nextTurn() + cells.substring(6);
						} else {
							coordinateOccupiedMessage();
						}
					}
				} else if (c2 == 1) {
					if (c1 == 1) {
						if (isEmptyCell(cells, 6)) {
							return cells.substring(0, 6) + nextTurn() + cells.substring(7);
						} else {
							coordinateOccupiedMessage();
						}
					} else if (c1 == 2) {
						if (isEmptyCell(cells, 7)) {
							return cells.substring(0, 7) + nextTurn() + cells.substring(8);
						} else {
							coordinateOccupiedMessage();
						}
					} else if (c1 == 3) {
						if (isEmptyCell(cells, 8)) {
							return cells.substring(0, 8) + nextTurn();
						} else {
							coordinateOccupiedMessage();
						}
					}
				}
			} else if ((coordinate1.length() == 1 && coordinate1.charAt(0) > 47 && coordinate1.charAt(0) < 58) &&
					(coordinate2.length() == 1 && coordinate2.charAt(0) > 47 && coordinate2.charAt(0) < 58)) {
				System.out.println("Coordinates should be from 1 to 3!");
			} else {
				System.out.println("You should enter numbers!");
			}
		}
	}

	private static String getResult(String cells) {
		char[][] arr = getArray(cells);

		boolean isXWin = isWin(arr, 'X');
		boolean isOWin = isWin(arr, 'O');
//		System.out.println("isXWin? " + isXWin);
//		System.out.println("isOWin? " + isOWin);
//		System.out.println("isNormalCount(arr) = " + isNormalCount(arr));
//		System.out.println(isXWin == isOWin);
		boolean isImpossible = (isXWin && isOWin) || isNormalCount(arr);
//		boolean isImpossible = (isXWin && isOWin) ? true : isNormalCount(arr);
//		System.out.println("isImpossible? " + isImpossible);
		boolean isFinished = isGameFinished(arr);

		if (isImpossible) {
			System.out.println("Impossible");
			return "Impossible";
		} else if (isXWin) {
			System.out.println("X wins");
			return "X wins";
		} else if (isOWin) {
			System.out.println("O wins");
			return "O wins";
		} else if (!isFinished) {
//			System.out.println("Game not finished");
			return "Game not finished";
		} else {
			System.out.println("Draw");
			return "Draw";
		}
	}

	// Draws the matrix from given input string
	private static void drawMatrix(String cells) {
		System.out.println("---------");

		for (int i = 0; i < cells.length(); i++) {
			if (i % 3 == 0) {
				System.out.print("|");
			}

			System.out.print(" " + cells.charAt(i));

			if (i == 2 || i == 5 || i == 8) {
				System.out.println(" |");
			}

		}
		System.out.println("---------");
	}

	// Converts the string to dual-dimensional array 3*3
	private static char[][] getArray(String cells) {
		int count = 0;
		char[][] array = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				array[i][j] = cells.charAt(count++);
			}
		}
		return array;
	}

	// Checks is the input char is win
	private static boolean isWin(char[][] cArr, char c) {

		if (
			// horizontal check
				(cArr[0][0] == cArr[0][1] && cArr[0][0] == cArr[0][2] && cArr[0][0] == c) ||
						(cArr[1][0] == cArr[1][1] && cArr[1][0] == cArr[1][2] && cArr[1][0] == c) ||
						(cArr[2][0] == cArr[2][1] && cArr[2][0] == cArr[2][2] && cArr[2][0] == c) ||
						// vertical check
						(cArr[0][0] == cArr[1][0] && cArr[0][0] == cArr[2][0] && cArr[0][0] == c) ||
						(cArr[0][1] == cArr[1][1] && cArr[0][1] == cArr[2][1] && cArr[0][1] == c) ||
						(cArr[0][2] == cArr[1][2] && cArr[0][2] == cArr[2][2] && cArr[0][2] == c) ||
						// diagonal check
						(cArr[0][0] == cArr[1][1] && cArr[0][0] == cArr[2][2] && cArr[0][0] == c) ||
						(cArr[0][2] == cArr[1][1] && cArr[0][2] == cArr[2][0] && cArr[0][2] == c)
		) {
//			System.out.println(c + " wins");
			return true;
		} else {
//			System.out.println(c + " lose");
			return false;
		}
	}

	// Checks the different between of 'X' and 'O' - lower or larger than 1
	private static boolean isNormalCount(char[][] array) {
		int x = 0, o = 0;

		for (char[] a : array) {
			for (char c : a) {
				if (c == 'X') x++;
				if (c == 'O') o++;
			}
		}

//		System.out.println(Math.max(x, o) - Math.min(x, o));
		return (Math.max(x, o) - Math.min(x, o)) > 1;
	}

	// Checks is the exist empty place '_' or whitespace ' ';
	private static boolean isGameFinished(char[][] array) {

		for (char[] a : array) {
			for (char c : a) {
				if (c == '_' || c == ' ') return false;
			}
		}

		return true;
	}
}
