// Description: This class is used for reading the input sudoku file and inserting the data in a 9x9 array.

package sudokuSolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	public FileReader(){
		
	}
//	Reads input txt file, updates array, and changes any '.' characters to 0.
	public static int[][] inputReader() {
	int boardSize = 9;
	int[][] board = new int [boardSize][boardSize];
	String fileName = "sudokuInput.txt";
	try {
		Scanner fileScanner = new Scanner(new File(fileName));
		int rowCount = 0;
		while(fileScanner.hasNextLine()) {// reads file and updates array with values
			String line = fileScanner.nextLine();
			for(int i = 0; i < line.length(); i++) {
				board[rowCount][i] = line.charAt(i);
				if(board[rowCount][i] == 46) {// replaces all'.' with 0
					board[rowCount][i] = 48;
				}
				board[rowCount][i] = Character.getNumericValue(board[rowCount][i]); // converts char to int
			}
			rowCount++;
		}
	} catch (FileNotFoundException e) {
		System.out.println("Error: file not found"); // displays error message to the console if the input file is not found
		e.printStackTrace();
	}
	System.out.println();
	return board;	
	}
	
}
