package space_invaders;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spacegame {

	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel botPanel;
	private JLabel score;
	private JLabel highScore;
	private JLabel lives;
	private JButton newGame;
	private JPanel spacePanel;
	
	public void play() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		frame = new JFrame("SpaceInv");
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));		
		
		topPanel = new JPanel(new FlowLayout());
		mainPanel.add(topPanel);
		
		spacePanel = new JPanel();
		spacePanel.add(new Space());
		spacePanel.setBackground(Color.black);
		mainPanel.add(spacePanel);
		
		botPanel = new JPanel(new FlowLayout());
		mainPanel.add(botPanel);
		
		
		score = new JLabel("Score: ");
		topPanel.add(score);
		
		highScore = new JLabel("Highscore: ");
		topPanel.add(highScore);
		
		lives = new JLabel("Lives: ");
		topPanel.add(lives);
		
		newGame = new JButton("New Game");
		botPanel.add(newGame);
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainPanel);
		
		frame.pack();
	    frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
