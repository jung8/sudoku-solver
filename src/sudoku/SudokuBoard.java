// Description: This class is for the GUI. It creates a JFrame and adds a JPanel(SudokuSquare) which also contains another JPanel(SudokuCell).
// When the user starts the program from the Client class the GUI is populated with the values from the starting sudoku board. When the SOLVE
// button is pressed the GUI then displays the solved sudoku puzzle and also displays it to the console.
package sudoku;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SudokuBoard  {
	
	public SudokuBoard(int board[][]) {
		JFrame frm = new JFrame("Sudoku Solver"); //creates the new frame with a title
		frm.setLayout(new BorderLayout()); // sets the layout to border layout
		JPanel centerPnl = new JPanel();  // creates a new JPanel
		centerPnl.setLayout(new GridLayout(3,3)); // formats the layout to 3x3
		
		SudokuSquare[][] square = new SudokuSquare[3][3]; // creates a 3x3 array
		for(int i = 0; i < 3; i++) { // populates the square 3x3 array
			for(int j = 0; j < 3; j++) {
				square[i][j] = new SudokuSquare(board, i, j); // sets mapping from the 3x3 square to the 9x9 sudoku board
				centerPnl.add(square[i][j]); // adds the 3x3 matrix to the 3x3 grid
			}
		}
		frm.add(centerPnl, BorderLayout.CENTER); //adds the panel to the frame

		JButton btn = new JButton("SOLVE");	
		frm.add(btn, BorderLayout.SOUTH);
		
		frm.setVisible(true);
		frm.pack();
		frm.setPreferredSize(new Dimension(200,200));	
		
// when the solve button in clicked the original JPanel is removed and a new one is added in its place with the solve sudoku board
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frm.remove(centerPnl);//removes the center panel 
				JPanel centerPnl = new JPanel(); // adds a new panel
				centerPnl.setLayout(new GridLayout(3,3));
				int solvedBoard[][] = SudokuSolver.solve(board); // populates a new array the completed sudoku board
				SudokuSquare[][] square = new SudokuSquare[3][3];
				for(int i = 0; i < 3; i++) {
					for(int j = 0; j < 3; j++) {
						square[i][j] = new SudokuSquare(solvedBoard, i, j);//maps to the solvedBoard
						centerPnl.add(square[i][j]);
					}
				}
				frm.add(centerPnl, BorderLayout.CENTER);
				frm.validate(); 
				
        System.out.println("Solved Board:");
				for(int i = 0; i < solvedBoard.length; i++) {   //displays the solved board to the console
					for(int j = 0; j < solvedBoard.length; j++) {
						System.out.print(solvedBoard[i][j] + " ");
					}
					System.out.println();
				}
			}
		});
	}
}


