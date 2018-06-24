package space_invaders;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spacepic {
	
	private Image missile;
	private Image ship;
	private Image inv1a;
	private Image inv1b;
	private Image inv2a;
	private Image inv2b;
	private Image inv3a;
	private Image inv3b;
	private Image invD;
	
	enum ImgType {	
		MISSILE,
		SHIP,
		INV1,
		INV2,
		INV3,
		INV4,
		INVD
	}
	
	public Spacepic() throws FileNotFoundException, IOException {
		String base = "images/";
		// iMac String base = base + "";
		this.inv1a = ImageIO.read(new FileInputStream(base + "inv2a.png"));
		this.inv1b = ImageIO.read(new FileInputStream(base + "inv2b.png"));
		this.inv2a = ImageIO.read(new FileInputStream(base + "inv3a.png"));
		this.inv2b = ImageIO.read(new FileInputStream(base + "inv3b.png"));
		this.inv3a = ImageIO.read(new FileInputStream(base + "inv4a.png"));
		this.inv3b = ImageIO.read(new FileInputStream(base + "inv4b.png"));
		this.invD = ImageIO.read(new FileInputStream(base + "invD.png"));
		this.ship = ImageIO.read(new FileInputStream(base + "ship.png"));
		this.missile = ImageIO.read(new FileInputStream(base + "missile.png"));
	}
 
	public Image getImage(ImgType imgType, int frame) {
		switch (imgType) {
		case MISSILE:
			return missile;
		case SHIP:
			return ship;
		case INV1:
			if(Invader.collision) {
				return invD;
			}
			if(frame == 0) {
				return inv1a;
			}
			else {
				return inv1b;
			}
		case INV2:
			if(Invader.collision) {
				return invD;
			}
			if(frame == 0) {
				return inv2b;
			}
			else {
				return inv2a;
			}
		case INV3:
			if(Invader.collision) {
				return invD;
			}
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

