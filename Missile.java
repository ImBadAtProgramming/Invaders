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
	public static boolean active = false;
	
	public Missile(ImgType imgType, Spacepic spacepic, int x, int y, int xSize, int ySize) {
		this.imgType = imgType;
		this.spacepic = spacepic;
		this.xSize = xSize;
		this.ySize = ySize;
		this.x = x;
		this.y = y;
	}
	public static Rectangle getRect() {
		if(!active) {
			return null;
		}
		return  new Rectangle(x, y, x + 12, y + 19);
	}
	public void draw(Graphics g) {
		if(active) {
			g.drawImage(getImage(), getX(), getY(), xSize, ySize, null);
		}
	}
	public static Image getImage() {	
		return spacepic.getImage(imgType, 0, false);
	}
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}
	public static void moveUp() {
		if(active) {
			y = y - 7;
		}
	}
	public static void fire(int X, int Y) {
		x = X;
		y = Y;
		active = true;
	}
	public static void die() {
		active = false;
	}
}
