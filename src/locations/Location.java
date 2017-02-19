package locations;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import game.Box;
import game.Bully;
import game.NonPlayableObject;

import java.awt.Image;

public abstract class Location {
    protected ArrayList<NonPlayableObject> map;
    protected Image background;

    public ArrayList<NonPlayableObject> getMap() {
        return map;
    }
    
    public void draw(Graphics g, JPanel panel) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.background, 0, 0, panel);
        // draw boxes
        for(NonPlayableObject npo : this.map) {
        	g2d.drawImage(npo.getImage(), npo.getX(), npo.getY(), panel);
           
        }   
    }

    public abstract Location getLeft();
    public abstract Location getRight();
    public abstract Location getTop();
    public abstract Location getBottom();
}