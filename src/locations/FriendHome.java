package locations;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.NonPlayableObject;
import game.Box;
import game.Television;

public class FriendHome extends Location {

	private Television tv;
    public FriendHome() {
    	tv = new Television("Television.png",250,200);
        this.map = new ArrayList<NonPlayableObject>();
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(new ImageIcon("box.png").getImage(),i, 19));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(new ImageIcon("box.png").getImage(),0, i));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(new ImageIcon("box.png").getImage(),19, i));
        }
        map.add(tv);
    }
    
    public Television getTelevision()
    {
    	return tv;
    }

    public Location getLeft() {
        return null;
    }
    
    public Location getRight() {
        return null;
    }  
    public Location getTop() {
        return new Outside();
    }  
    public Location getBottom() {
        return null;
    }     



}
