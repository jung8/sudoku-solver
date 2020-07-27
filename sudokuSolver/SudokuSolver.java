// Description: This class contains the methods to solve the sudoku puzzle and package the completed board in a 9x9 array matrix

package sudokuSolver;

public class SudokuSolver {
	
	public SudokuSolver() {

	}
	public static int[][] solve(int board[][]) {
		setOnBoard(board, 0, 0);
		return board;
	}
	// recursive method with backtracking to solve the sudoku puzzle
	private static boolean setOnBoard(int board[][], int row, int col) {
		if(row == board.length-1 && col == board.length) {// stop control for reaching the end of the board
			return true;
		}
		if(col == board.length) {// moves to the next row if col is over the max index
			col = 0;
			row += 1;
		}
		if(board[row][col] == 0) {
			for(int n = 1; n < 10; n++) {// iterates through possible numbers to set
				if(isSafe(board, n, row, col)) { // checks if number is safe to set on board
					board[row][col] = n;
					if(setOnBoard(board, row, col+1)) { // recursive call inc col
						return true;
					}
				}
			}
			board[row][col] = 0;
			return false; // causes backtracking	
		}
		if(setOnBoard(board, row, col+1)) { // recursive call increments col in cases where board[row[col] != 0
			return true;					
		}
		return false;
	}
	private static boolean isSafe(int board[][], int n, int row, int col) { //checks row, column, and quadrant if it is safe to place number
		for(int i = 0; i < board.length; i++) {
			if(n == board[i][col]) {
				return false;
			}
			if(n == board[row][i]) {
				return false;
			}
		}
		return squareCheck(board, n, row, col);
	}
	private static boolean squareCheck(int board[][], int n, int row, int col) { //checks if valid to place number in a quadrant
		int rowMin = setMin(row);
		int rowMax = setMax(row);
		int colMin = setMin(col);
		int colMax = setMax(col);
		for(int i = rowMin; i <= rowMax; i++) {
			for(int j = colMin; j <= colMax; j++) {
				if(board[i][j] == n) {
					return false;
				}
			}
		}
		return true;
	}
	private static int setMin(int x) {
		int min;
		if(x < 3) {
			min = 0;
		}
		else if(x > 2 && x < 6) {
			min = 3;
		}
		else {
			min = 6;
		}
		return min;
	}
	private static int setMax(int x) {
		int max;
		if(x < 3) {
			max = 2;
		}
		else if(x > 2 && x < 6) {
			max = 5;
		}
		else {
			max = 8;
		}
		return max;
	}

}
