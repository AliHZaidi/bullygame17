package game;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Box extends NonPlayableObject {
    public Box(Image image, int gridX, int gridY) {
        super(image, gridX * 32, gridY * 32);
    }
}