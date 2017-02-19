package locations;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.Box;
import game.NonPlayableObject;

public class School extends Location {
	
	public School() {
		super.map = new ArrayList<NonPlayableObject>();
		super.background = new ImageIcon("schoolfloor.png").getImage();
		for (int i = 0; i < 20; i++) {
			super.map.add(new Box(new ImageIcon("BLACK.png").getImage(), i, 0));
        }
		for (int i = 0; i < 20; i++) {
			super.map.add(new Box(new ImageIcon("locker.png").getImage(), i, 1));
        }
		for (int i = 0; i < 20; i++) {
			super.map.add(new Box(new ImageIcon("locker2.png").getImage(), i, 17));
        }
		for (int i = 0; i < 20; i++) {
			super.map.add(new Box(new ImageIcon("BLACK.png").getImage(), i, 18));
        }
		
		for (int i = 0; i < 20; i++) {
			super.map.add(new Box(super.background, 20, i));
        }
	}

	public Location getLeft() {
		return new Outside();
	}

	public Location getRight() {
		return null;
	}

	public Location getTop() {
		return null;
	}

	public Location getBottom() {
		return null;
	}

}
