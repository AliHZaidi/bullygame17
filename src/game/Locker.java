package game;

import java.awt.Image;

public class Locker extends NonPlayableObject {
	
	boolean checkedLocker = false;

	public Locker(Image image, int x, int y) {
		super(image, x*32, y*32);
	}

	public Dialogue getPrompt(Character x, boolean shouldChange){
		if (!checkedLocker) {
			if (shouldChange) {
				x.decreaseHappiness(35);
				checkedLocker = true;
			}
			return new Dialogue("1 NEW TEXT MESSAGE:\nlmfao u have no friends. gonna be lonely 4eva");
		}
		
		return null;
	}
}
