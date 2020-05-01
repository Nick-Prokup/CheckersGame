import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CheckerBoard extends JPanel{
	
	private int x = 0, y = 0;
	private static final int ROW = 8, COLUMN = 8;
	
	/**
	 * constructor that will pass in the boardstatus
	 * @param boardStatus
	 */
	public CheckerBoard(char [][] boardStatus) {
		setSize(480, 480);
		setLayout(new GridLayout(8, 8));
		setVisible(true);
		CheckerPiece p;
		setBoardStatus(boardStatus);
		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COLUMN; j++)
				{
					p = new CheckerPiece (i, j, boardStatus[i][j]);
					add(p);
					repaint();
				}
		}
	}
	
	public void setBoardStatus(char[][] boardStatus) {
		boardStatus = new char[][] 
				{
					{'e','b','e','b','e','b','e','b'},
					{'b','e','b','e','b','e','b','e'},
					{'e','b','e','b','e','b','e','b'},
					{'e','e','e','e','e','e','e','e'},
					{'e','e','e','e','e','e','e','e'},
					{'r','e','r','e','r','e','r','e'},
					{'e','r','e','r','e','r','e','r'},
					{'r','e','r','e','r','e','r','e'},
				};
	}

	
}
