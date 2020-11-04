// Description: This is the main program area. This program takes the starting input file, reads it and stores the data in an array matrix
// The input is then corrected by replacing all periods with zeros and then displayed to the users console. The graphical user interface (GUI)
// also displays the same data until the user pressed the SOLVE button. At this point the solved sudoku puzzle will be displayed to the user
// console and on the GUI
package sudoku;

public class Client {

	public static void main(String[] args) {
		int startBoard[][] = FileReader.inputReader(); // stores the starting board in startBoard[][]
		new SudokuBoard(startBoard); // passes the starting board to setup the GUI
    System.out.println("\nUnsolved Board:"); // print a blank line for Repl.it
		for(int i = 0; i < startBoard.length; i++) {   //displays the starting board to the console
			for(int j = 0; j < startBoard.length; j++) {
				System.out.print(startBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
