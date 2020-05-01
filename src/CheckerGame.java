import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;



public class CheckerGame extends JFrame implements ActionListener{
	
	static int bLeft = 12, rLeft = 12;
	static String turn = "<--", stat = "Black: " + bLeft + " " + turn + " Red: " + rLeft; 
	
	char[][] boardStatus = new char[][] 
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
	
	/**
	 * Empty constructor of the checkerGame class
	 */
	public CheckerGame() {
		// set sizes and title
		setSize(505, 580);
		setTitle("Checker Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// declare and initialize variables (MAYBE change to menu vs item so that they can drop down)
		JMenuBar topMenu = new JMenuBar();
		JMenu gameOpt= new JMenu("Game");
		JMenu helpOpt = new JMenu("Help");
		JMenuItem gOpt1 = new JMenuItem("New");
		JMenuItem gOpt2 = new JMenuItem("Exit");
		JMenuItem hOpt1 = new JMenuItem("Checker Game Rules");
		JMenuItem hOpt2 = new JMenuItem("About Checker Game App");
		
		JPanel bottomPanel = new JPanel();
	
		CheckerBoard cb = new CheckerBoard(boardStatus);
		

		// add objects
		topMenu.add(gameOpt);
		topMenu.add(helpOpt);
		gameOpt.add(gOpt1);
		gOpt1.addActionListener(this);
		gameOpt.add(gOpt2);
		gOpt2.addActionListener(this);
		helpOpt.add(hOpt1);
		hOpt1.addActionListener(this);
		helpOpt.add(hOpt2);
		hOpt2.addActionListener(this);
		add(topMenu);
		
		bottomPanel.add(new JLabel(stat));
		add(bottomPanel);
		bottomPanel.add(new JLabel("This game was developed by Nick Prokup"));
		add(bottomPanel);
		
		add(cb);
		
		// organize layouts
		bottomPanel.setBorder(new LineBorder(Color.BLACK));
		bottomPanel.setLayout(new GridLayout(2,1));

		
		// add to frame with border layout
		this.add(topMenu, BorderLayout.NORTH);
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(cb, BorderLayout.CENTER);
		
	}
	
	/**
	 * performs an action for the event selected
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// menu actions
		JFrame frame = new JFrame();
		if (e.getActionCommand().equals("New"))
		{
			CheckerGame test = new CheckerGame();
			test.setVisible(true);
		}
		if (e.getActionCommand().equals("Exit"))
			System.exit(0);
		if (e.getActionCommand().equals("Checker Game Rules"))
			JOptionPane.showMessageDialog(frame, "Rules: https://www.wikihow.com/Play-Checkers ");
		if (e.getActionCommand().equals("About Checker Game App"))
			JOptionPane.showMessageDialog(frame, "Nick Prokup, prokupnj@miamioh.edu, Miami University");

	}

	public static void main(String[] args) {
		CheckerGame test = new CheckerGame();
		test.setVisible(true);
	}
}
