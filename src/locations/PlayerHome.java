package locations;
import java.util.ArrayList;

import game.Box;
import game.Computer;

public class PlayerHome extends Location {
	
	private Computer cpu;
	
    public PlayerHome() {
        this.map = new ArrayList<Box>();
        for(int i = 0; i < 20; i++) {
            super.map.add(new Box(i, 0));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(0, i));
        }
        for(int i = 1; i < 20; i++) {
            super.map.add(new Box(19, i));
        }
        cpu = new Computer(5,5);
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