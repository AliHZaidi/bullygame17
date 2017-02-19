package game;
import java.awt.Image;
import javax.swing.ImageIcon;

public class NPC extends NonPlayableObject {

	private Image image;

	public NPC() {
		super(new ImageIcon("craft.png").getImage(), 150, 800);
	}

	public Image getImage() {
		return image;
	}
}



