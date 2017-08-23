package space_invaders;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Spaceinv {

	public static void main (String args[]) throws FileNotFoundException, IOException {
		Spacegame game = new Spacegame();
		game.play();
	}
}
