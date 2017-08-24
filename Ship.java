package space_invaders;

import java.awt.Graphics;
import java.awt.Image;

import space_invaders.Spacepic.ImgType;

public class Ship {

	private int x;
	private int y;
	private Spacepic spacepic;
	private ImgType imgType;
	
	private static boolean moveRight = false;
	private static boolean moveLeft = false;
	
	public Ship(ImgType imgType, Spacepic spacepic, int x, int y) {
		this.imgType = imgType;
		this.spacepic = spacepic;
		this.x = x;
		this.y = y;
		
	}
	
	public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, null);
	}
	public Image getImage() {	
		return spacepic.getImage(imgType, 0);
	}
	
	public int getX() {
		return x;
	}
	
	public void adjustX() {
		if(x < 500) {
			x = 25;
		}
		else {
			x = Space.width - 100;
		}
	}
	
	public void moveRight() {
		x = x + 3;
	}
	public void moveLeft() {
		x = x - 3;
	}
	public void fire() {
		System.out.print("You Fired!");
	}
}
