package space_invaders;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spacepic {
	
	private Image ship;
	private Image inv1a;
	private Image inv1b;
	private Image inv2a;
	private Image inv2b;
	private Image inv3a;
	private Image inv3b;
	
	enum ImgType {	
		SHIP,
		INV1,
		INV2,
		INV3
	}
	
	public Spacepic() throws FileNotFoundException, IOException {
		
		this.ship = ImageIO.read(new FileInputStream("images/space_invaders/ship.png"));
		this.inv1a = ImageIO.read(new FileInputStream("images/space_invaders/inv2a.png"));
		this.inv1b = ImageIO.read(new FileInputStream("images/space_invaders/inv2b.png"));
		this.inv2a = ImageIO.read(new FileInputStream("images/space_invaders/inv3a.png"));
		this.inv2b = ImageIO.read(new FileInputStream("images/space_invaders/inv3b.png"));
		this.inv3a = ImageIO.read(new FileInputStream("images/space_invaders/inv4a.png"));
		this.inv3b = ImageIO.read(new FileInputStream("images/space_invaders/inv4b.png"));
	}
	
	public Image getImage(ImgType imgType, int frame) {
		switch (imgType) {
		case SHIP:
			return ship;
		case INV1:
			if(frame == 0) {
				return inv1a;
			}
			else {
				return inv1b;
			}
		case INV2:
			if(frame == 0) {
				return inv2b;
			}
			else {
				return inv2a;
			}
		case INV3:
			if(frame == 0) {
				return inv3a;
			}
			else {
				return inv3b;
			}
		}
		return null;
	}
}

