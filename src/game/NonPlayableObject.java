package game;
import java.awt.Image;

import javax.swing.ImageIcon;

public class NonPlayableObject {
	
	protected int x;
    protected int y;
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
    public Dialogue getPrompt(Character x, boolean shouldChange){
    	return null;
    }
}
