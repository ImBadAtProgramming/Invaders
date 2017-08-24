package space_invaders;

import java.awt.Graphics;
import java.awt.Image;

import space_invaders.Spacepic.ImgType;

public class Invader {

	private int x;
	private int y;
	private int xSize;
	private int ySize;
	private int frame;
	private Spacepic spacepic;
	private ImgType imgType;
	
	public Invader(ImgType imgType, int x, int y, int xSize, int ySize, Spacepic spacepic, int frame) {
		this.x = x;
		this.y = y;
		this.xSize = xSize;
		this.ySize = ySize;
		this.spacepic = spacepic;
		this.imgType = imgType;
		this.frame = frame = 0;
	}
	
	public void cngFrame() {
		if(frame == 0) {
			frame = 1;
		}
		else {
			frame = 0;
		}
	}
	
	public void moveRight() {
		x = x + Space.xSpacing;
	}
	
	public void moveDown() {
		y = y + Space.ySpacing;
	}
	
	public void moveLeft() {
		x = x - Space.xSpacing;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Image getImage() {
		
		return spacepic.getImage(imgType, frame);
	}

	public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, xSize, ySize, null);
	}
}
