package locations;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.NonPlayableObject;
import game.Box;
import game.Television;

public class FriendHome extends Location {

	private Television tv;
    public FriendHome() {

        super.background = new ImageIcon("fHome.png").getImage();
    	tv = new Television("Television.png",3,12);
        this.map = new ArrayList<NonPlayableObject>();
        ImageIcon homeWall = new ImageIcon("box.png");
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(homeWall.getImage(),i, 19));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(homeWall.getImage(),0, i));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(homeWall.getImage(),19, i));
        }

        //top wall
        for(int i = 0; i < 20; i++) {
            if(i < 8 || i > 12) {
                super.map.add(new Box(homeWall.getImage(), i, 0));
            }
            
        }

        //bedroom
        for(int i = 18; i > 11; i--) {
            
                super.map.add(new Box(homeWall.getImage(), 13, i));   
            
        }
        super.map.add(new Box(homeWall.getImage(), 14, 12));
        super.map.add(new Box(homeWall.getImage(), 15, 12));

        map.add(tv);
    }
    
    public Television getTelevision()
    {
    	return tv;
    }

    public String getLeft() {
        return null;
    }
    
    public String getRight() {
        return null;
    }  
    public String getTop() {
        return "outside";
    }  
    public String getBottom() {
        return null;
    }     



}
