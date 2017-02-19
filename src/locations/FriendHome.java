package locations;

import java.util.ArrayList;

import game.Box;

public class FriendHome extends Location {

	
    public FriendHome() {
        this.map = new ArrayList<Box>();
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(i, 19));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(0, i));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(19, i));
        }
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
