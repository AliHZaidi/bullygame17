import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Image;

public abstract class Location {
    public ArrayList<Box> map;
    public Image background;

    public ArrayList<Box> getMap() {
        return map;
    }
    
    public void draw(Graphics g, JPanel panel) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.background, 0, 0, panel);
         //draw boxes
        for(Box box : this.map) {
            g2d.drawImage(box.getImage(), box.getX(), box.getY(), panel);
        }
        
    }

    abstract Location getAdjacent();
}