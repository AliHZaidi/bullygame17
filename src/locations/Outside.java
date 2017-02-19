package locations;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import game.Box;

public class Outside extends Location {

    public Outside() {
        super.map = new ArrayList<Box>();
        super.background = new ImageIcon("outdoor.png").getImage();
        
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(0, i));
        }
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(19, i));
        }
    }

    public Location getLeft() {
        return new Home();
    }
    public Location getRight() {
        return new Home();
    }  
    public Location getTop() {
        return new Home();
    }  
    public Location getBottom() {
        return new Home();
    }      
}