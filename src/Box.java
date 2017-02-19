import java.awt.Image;

import javax.swing.ImageIcon;

public class Box {
	
    private int x;
    private int y;
    
    public Box(int gridX, int gridY) {
        this.x = gridX * 32;
        this.y = gridY * 32;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return new ImageIcon("box.png").getImage();
    }


}