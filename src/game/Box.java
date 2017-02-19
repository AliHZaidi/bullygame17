package game;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Box extends NonPlayableObject {
    public Box(int gridX, int gridY) {
        super(new ImageIcon("box.png").getImage(), gridX * 32, gridY * 32);
    }
}