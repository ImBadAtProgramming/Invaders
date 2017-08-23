package space_invaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JComponent;

import space_invaders.Spacepic.ImgType;

public class Space extends JComponent {
	private static final long serialVersionUID = 1L;

	private static final int width = 1200;
	private static final int height = 1200;
	private static final int cols = 11;
	private static final int rows = 5;
	private static final int numInvs = cols * rows;
	private static final int xSpacing = 75;
	private static final int ySpacing = 75;
	private static final int xSize = 44;
	private static final int ySize = 44;
	private Invader[] invader;
	
	public Space() throws FileNotFoundException, IOException {
		Spacepic spacepic = new Spacepic();
		this.setPreferredSize(new Dimension(width, height));
		
		invader = new Invader[numInvs];
		
		for(int x = 0; x < cols; x++) {
			for(int y = 0; y < rows; y++) {
				invader[x + y * cols] = new Invader(ImgType.INV1, x * xSpacing, y * ySpacing, xSize, ySize, spacepic);
			}
		}
		
	}
	public void paintComponent(Graphics g)
    {	
        super.paintComponent(g);   
        
        for(int inv = 0; inv < numInvs; inv++) {
        	
        	        	invader[inv].draw(g);
        }
    }
	
}
