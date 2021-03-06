package locations;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.Box;
import game.Bully;

import game.Locker;

import game.NonPlayableObject;

public class School extends Location {
	
	public School() {
		super.map = new ArrayList<NonPlayableObject>();
		super.background = new ImageIcon("schoolfloor.png").getImage();
		for (int i = 0; i < 20; i++) {
			super.map.add(new Box(new ImageIcon("BLACK.png").getImage(), i, 0));
        }
		for (int i = 0; i < 20; i++) {
			if (i == 14) {
				super.map.add(new Locker(new ImageIcon("player_locker.png").getImage(), i, 1));
			}
			else {
				super.map.add(new Box(new ImageIcon("locker.png").getImage(), i, 1));
			}
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
		super.map.add(new Bully(new ImageIcon("bully_front_betweenStep.png").getImage(), 150, 150));
	}

	public String getLeft() {
		return "outside";
	}

	public String getRight() {
		return null;
	}

	public String getTop() {
		return null;
	}

	public String getBottom() {
		return null;
	}

}
