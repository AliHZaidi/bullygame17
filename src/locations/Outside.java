package locations;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import game.Box;
import game.NonPlayableObject;

public class Outside extends Location {

    public Outside() {
        super.map = new ArrayList<NonPlayableObject>();
        super.background = new ImageIcon("outdoor.png").getImage();
        ImageIcon homeWall = new ImageIcon("box.png");
        //top wall
        for(int i = 0; i < 20; i++) {
            if(i < 8 || i > 12) {
                super.map.add(new Box(homeWall.getImage(), i, 0));
            }
            
        }

        //
        for(int i = 0; i < 20; i++) {
            if(i < 8 || i > 12) {
                super.map.add(new Box(homeWall.getImage(), i, 19));
            }
            
        }
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