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
		
		this.ship = ImageIO.read(new FileInputStream("images/ship.png"));
		this.inv1a = ImageIO.read(new FileInputStream("images/inv2a.png"));
		this.inv1b = ImageIO.read(new FileInputStream("images/inv2b.png"));
		this.inv2a = ImageIO.read(new FileInputStream("images/inv3a.png"));
		this.inv2b = ImageIO.read(new FileInputStream("images/inv3b.png"));
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
		}
		return null;
	}
}

