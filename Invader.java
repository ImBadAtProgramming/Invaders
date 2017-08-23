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
	
	public Invader(ImgType imgType, int x, int y, int xSize, int ySize, Spacepic spacepic) {
		this.x = x;
		this.y = y;
		this.xSize = xSize;
		this.ySize = ySize;
		this.spacepic = spacepic;
		this.imgType = imgType;
		frame = 0;
	}

	public Image getImage() {
		
		return spacepic.getImage(imgType, frame);
	}

	public void draw(Graphics g) {
        g.drawImage(getImage(), x, y, xSize, ySize, null);
	}
}
