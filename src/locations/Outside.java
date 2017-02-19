package locations;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import game.Box;
import game.NonPlayableObject;

public class Outside extends Location {

    public Outside() {
        super.map = new ArrayList<NonPlayableObject>();
        super.background = new ImageIcon("outdoor.png").getImage();
    }

    public Location getLeft() {
        return new BasketBallCrt();
    }
    public Location getRight() {
        return new School();
    }  
    public Location getTop() {
        return new PlayerHome();
    }  
    public Location getBottom() {
        return new FriendHome();
    }      
}