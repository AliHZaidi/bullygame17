package locations;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.Box;
import game.Computer;
import game.NonPlayableObject;

public class PlayerHome extends Location {
	
	private Computer cpu;
	
    public PlayerHome() {
        super.map = new ArrayList<NonPlayableObject>();
        super.background = new ImageIcon("home.png").getImage();
        ImageIcon homeWall = new ImageIcon("box.png");
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(homeWall.getImage(), i, 0));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(homeWall.getImage(), 0, i));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(homeWall.getImage(), 19, i));
        }

        //add walls for bedroom
        for(int i = 1; i < 10; i++) {
            super.map.add(new Box(homeWall.getImage(), i, 6));
        }
        super.map.add(new Box(homeWall.getImage(), 9, 1));
        super.map.add(new Box(homeWall.getImage(), 9, 4));
        super.map.add(new Box(homeWall.getImage(), 9, 5));
        
        cpu = new Computer(new ImageIcon("Computer.png").getImage(), 6,1);
        super.map.add(cpu);

        //
        for(int i = 0; i < 20; i++) {
            if(i < 8 || i > 12) {
                super.map.add(new Box(homeWall.getImage(), i, 19));
            }
            
        }
    }

    public Computer getCPU(){
    	return cpu;
    }

    public Location getLeft() {
        return null;
    }
    
    public Location getRight() {
        return null;
    }  
    public Location getTop() {
        return null;
    }  
    public Location getBottom() {
        return new Outside();
    }     
   
}