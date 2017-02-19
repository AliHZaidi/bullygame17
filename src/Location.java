import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class Location {

    abstract ArrayList<Box> getMap();
    abstract void draw(Graphics g, JPanel panel);
    abstract Location getAdjacent();

}