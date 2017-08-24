package space_invaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.Timer;

import space_invaders.Spacepic.ImgType;

public class Space extends JComponent implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;

	static final int width = 850;
	static final int height = 800;
	private static final int cols = 11;
	private static final int rows = 5;
	private static final int numInvs = cols * rows;
	
	static final int xSpacing = 45;
	static final int ySpacing = 45;
	private static final int xSize = 33;
	private static final int ySize = 24;
	
	private static boolean right = true;
	private static boolean down = false;
	private static boolean left = false;
	private static boolean decide;
	
	private static char c;
	private static long counter = 0;
	private static int movement = 0;
	
	private Invader[] invader;
	private Ship ship;
	Timer timer;
	
	public Space() throws FileNotFoundException, IOException {
		Spacepic spacepic = new Spacepic();
		this.setPreferredSize(new Dimension(width, height));
		
		ship = new Ship(ImgType.SHIP, spacepic, width / 2 - 35, height - 70);
		
		invader = new Invader[numInvs];
		
		for(int x = 0; x < cols; x++) {
			for(int y = 0; y < rows - 2; y++) {
				invader[x + y * cols] = new Invader(ImgType.INV1, x * xSpacing, y * ySpacing, xSize, ySize, spacepic, 0);
			}
			for(int y = rows - 2; y < rows; y++) {
				invader[x + y * cols] = new Invader(ImgType.INV2, x * xSpacing, y * ySpacing, xSize, ySize, spacepic, 0);
			}
		}
		
		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow();
		timer = new Timer(10, this);
		timer.start();
		
		
	}
	public void paintComponent(Graphics g)
    {	
        super.paintComponent(g);   
        
        ship.draw(g);
        
        for(int inv = 0; inv < numInvs; inv++) {
        		invader[inv].draw(g);
        }
    }
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		counter = counter + 1;
		
		if(ship.getX() < 25 || ship.getX() > width - 100) {
			ship.adjustX();
		}
		
		if(movement == 1) {
			ship.moveLeft();
		}
		if(movement == 2) {
			ship.moveRight();
		}
		if(movement == 3) {
			ship.fire();
		}
		
		if(counter % 10 == 0) {
			for(int inv = 0; inv < numInvs; inv++) {
				if(invader[inv].getX() > width - 60 && right) {
	    				down = true;
	    				right = false;
	    				decide = false;
				}
				else if(invader[inv].getX() < 25 && left) {
					down = true;
					left = false;
					decide = true;
				}
			}
			
			if(right) {
				for(int inv = 0; inv < numInvs; inv++) {
					invader[inv].cngFrame();
					invader[inv].moveRight();
					repaint();				
				}
				down = false;
			}
			if(left) {
				for(int inv = 0; inv < numInvs; inv++) {
					invader[inv].cngFrame();
					invader[inv].moveLeft();
					repaint();
				}
				down = false;
			}
			if (down) {
				for(int inv = 0; inv < numInvs; inv++) {
					invader[inv].moveDown();
					down = false;
					repaint();
				}
				if(!decide) {
					left = true;
				}
				else if(decide) {
					right = true;
				}
			}
		}
		repaint();
	}
	
	public void keyTyped(KeyEvent e) {
		c = e.getKeyChar();
		
		if(c == 's') {
			movement = 0;
		}
		
		if(c == 'a') {
			movement = 1;
		}
		if(c == 'd') {
			movement = 2;
		}
		if(c == ' ') {
			movement = 3;
		}
		repaint();
		
	}

	public void keyPressed(KeyEvent e) {
		c = e.getKeyChar();
		
		if(c == 'a') {
			movement = 1;
		}
		if(c == 'd') {
			movement = 2;
		}
		if(c == ' ') {
			movement = 3;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		movement = 0;
	}	
}
