package locations;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import game.Box;
import game.NonPlayableObject;

public class Outside extends Location {

    public Outside() {
        super.map = new ArrayList<NonPlayableObject>();
        super.background = new ImageIcon("outdoor.png").getImage();
        
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(0, i));
        }
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(19, i));
        }
    }

    public Location getLeft() {
        return new PlayerHome();
    }
    public Location getRight() {
        return new PlayerHome();
    }  
    public Location getTop() {
        return new PlayerHome();
    }  
    public Location getBottom() {
        return new PlayerHome();
    }      
}