// Description: This is the class that sets the data into each individual cell on the sudoku board
package sudoku;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SudokuCell extends JPanel{
  
	private JLabel txt = new JLabel();
	
	public SudokuCell() {
		
		add(txt);
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setPreferredSize(new Dimension(30,30)); // sets the size of the individual cell
	}
//	Receives an input number and sets it as a string
	public void setData(int a) {
		txt.setText(a + "");
	}
//	Returns txt string as an integer
	public int getData() {
		return Integer.parseInt(txt.getText());// converts from string to int
	}
}
