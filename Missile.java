package space_invaders;

import java.awt.Graphics;
import java.awt.Image;

import space_invaders.Spacepic.ImgType;

public class Missile {
	private static int x;
	private static int y;
	private static int xSize;
	private static int ySize;
	private static Spacepic spacepic;
	private static ImgType imgType;
	
	public Missile(ImgType imgType, Spacepic spacepic, int x, int y, int xSize, int ySize) {
		this.imgType = imgType;
		this.spacepic = spacepic;
		this.xSize = xSize;
		this.ySize = ySize;
		this.x = x;
		this.y = y;
	}
	public void draw(Graphics g) {
        g.drawImage(getImage(), chooseX(), chooseY(), xSize, ySize, null);
	}
	public static Image getImage() {	
		return spacepic.getImage(imgType, 0);
	}
	public static int chooseX() {
		if (Ship.fired == 1) {
			x = getX();
			return getX();
		}
		return x;
	}
	public static int chooseY() {
		if (Ship.fired == 1) {
			y = getY();
			return getY();
		}
		return y;
	}
	public void setX(int x) {
		this.x = chooseX();
	}
	public void setY(int y) {
		this.y = y;
	}
	public static int getX() {
		return Ship.getX() + 28;
	}
	public static int getY() {
		return Ship.getY() - 35;
	}
	public static void moveUp() {
		y = y - 7;
	}
}
