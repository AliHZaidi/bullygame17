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
        
        cpu = new Computer(new ImageIcon("Computer.png").getImage(), 250,200);
        super.map.add(cpu);
        
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