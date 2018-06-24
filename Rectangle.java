package space_invaders;

public class Rectangle {

	int x0;
	int x1;
	int y0;
	int y1;
	
	public Rectangle(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.x1 = x1;
		this.y0 = y0;
		this.y1 = y1;
	}
	public boolean overlap(Rectangle other) {
		
		if(other.x0 > x0 && other.x0 < x1) {
			if(other.y0 < y1 && other.y0 > y0) {
				//System.out.println("1");
				return true;
			}
		}
		if(other.x1 > x0 && other.x1 < x1) {
			if(other.y0 < y1 && other.y0 > y0) {
				System.out.println("2");
				return true;
			}
		}
		
		return false;	
	}
}
