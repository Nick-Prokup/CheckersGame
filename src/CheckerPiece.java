import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class CheckerPiece extends JComponent {
	
	char status;
	int row = 0, column = 0, x = 0, y = 0;


	/**
	 * Full constructor, checks values to make sure it is possible
	 * @param row, integer of row number
	 * @param column, integer of column number
	 * @param status, char of checker piece 
	 */
	public CheckerPiece(int row, int column, char status) {
		if (status != 'e' && status != 'b' && status != 'r')
			throw new IllegalArgumentException("The status is not valid");
		if(row < 0 || row > 7)
			throw new IllegalArgumentException("Row is not valid");
		if(column < 0 || column > 7)
			throw new IllegalArgumentException("Column is not valid");
	
		this.status = status;
		this.row = row;
		this.column = column;
		
	}
	
	/**
	 * overrides the paint component to create the image for the checkerboard
	 */
	public void paintComponent(Graphics g) {
		
		if ((row + column) % 2 == 0)
		{
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 60, 60);
			

		}
		else if((row + column) % 2 == 1)
		{
			g.setColor(Color.GREEN);
			g.fillRect(x, y, 60, 60);
			
		}
		
	
		// switch case to decide what piece gets laid down
		switch (status)
		{
		case 'e': 
			break;
		case 'b':
			g.setColor(Color.BLACK);
			g.fillOval(x+10, y+10, 40, 40);
			break;
		case 'r':
			x = 0;
			y = 0;
			g.setColor(Color.RED);
			g.fillOval(x+10, y+10, 40, 40);
			break;
		default:
			System.out.println("Not a valid option");
			break;
		}
			
	}
	
}
