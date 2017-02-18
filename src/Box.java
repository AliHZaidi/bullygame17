import java.awt.Image;

import javax.swing.ImageIcon;

public class Box {
	
    private int x;
    private int y;
    
    public Box(int x, int y) {
        this.x = x;
        this.y = y;
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