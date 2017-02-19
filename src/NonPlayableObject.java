import java.awt.Image;

import javax.swing.ImageIcon;

public class NonPlayableObject {
	
	private int x;
    private int y;
    private Image image;

	public NonPlayableObject(Image image, int x, int y) {
		this.image = image;
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
        return image;
    }
}
