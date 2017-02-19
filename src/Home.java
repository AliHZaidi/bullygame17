import java.util.ArrayList;

public class Home extends Location {
	private Computer cpu;
    public Home() {
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

    public Location getAdjacent() {
        return new Outside();
    }
    public Computer getCPU(){
    	return cpu;
    }
}