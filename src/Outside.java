import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Outside extends Location {

    private ArrayList<Box> map;

    public Outside() {
        this.map = new ArrayList<Box>();
        
        for(int i = 0; i < 20; i++) {
            this.map.add(new Box(0, i));
        }
        for(int i = 0; i < 20; i++) {
            this.map.add(new Box(19, i));
        }
    }

    public ArrayList<Box> getMap() {
        return this.map; 
    }

    public void draw(Graphics g, JPanel panel) {
        Graphics2D g2d = (Graphics2D) g;

         //draw boxes
        for(Box box : this.map) {
            g2d.drawImage(box.getImage(), box.getX(), box.getY(), panel);
        }
    }

    public Location getAdjacent() {
        return new Home();
    }

    
}