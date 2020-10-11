// Description: The class contains the first JPanel that is added to the GUI. Within it creates the 9 cells in a 3x3 format that
// correspond to the 9 numbers in each of the square panels.

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class SudokuSquare extends JPanel{
	
	public SudokuSquare(int board[][], int row, int col) {
		
		JPanel cellPnl = new JPanel();
			
		int rowStart = setStart(row);// sets the start location of the square in the 9x9 sudoku board
		int colStart = setStart(col);
		
		SudokuCell[][] cells = new SudokuCell[3][3];
		cellPnl.setLayout(new GridLayout(3,3));
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				cells[i][j] = new SudokuCell();
				cells[i][j].setData(board[i+rowStart][j+colStart]);	// sets the cell to the data on board
				
				if(col%2 != 0 && row%2 == 0) { // sets alternating colors of the squares for ease of reading
					cells[i][j].setBackground(Color.YELLOW);
				}
				else if(col%2 == 0 && row%2 != 0) {
					cells[i][j].setBackground(Color.YELLOW);
				}
				cellPnl.add(cells[i][j]); // adds the cell in to the cellPnl(JPanel) in grid format		
			}
		}
		add(cellPnl);
       
		setPreferredSize(new Dimension(100,100)); // sets the size of the quadrants	
			
	}
	private int setStart(int b) {
		int min;
			if(b == 0) {
				min = 0;
			}
			else if(b == 1) {
				min = 3;
			}
			else {
				min = 6;
			}
		return min;
	}
}
