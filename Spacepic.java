package space_invaders;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spacepic {
	
	private Image inv1a;
	private Image inv1b;
	
	enum ImgType {	
		INV1
	}
	
	public Spacepic() throws FileNotFoundException, IOException {
		
		this.inv1a = ImageIO.read(new FileInputStream("images/inv1a.png"));
		this.inv1b = ImageIO.read(new FileInputStream("images/inv1b.png"));
	}
	
	public Image getImage(ImgType imgType, int frame) {
		switch (imgType) {
		case INV1:
			if(frame == 0) {
				return inv1a;
			}
			else {
				return inv1b;
			}
		}
		return null;
	}
}

