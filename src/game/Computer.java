package game;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 
 */

/**
 * @author Matt
 *
 */
public class Computer extends NonPlayableObject{
	private Image img;
	private String[] meanComments;
	private String[] niceComments;
	private int position;
	public Computer(Image img, int x, int y){
		super(img,x*32, y*32);
		this.img = img;
		position = 0;
		meanComments = new String[4];
		meanComments[0] = "Wow that's so dumb! UR AN IDIOT XD";
		meanComments[1] = "LOL you're so ugly!";
		meanComments[2] = "NO ONE LOVES YOU";
		meanComments[3] = "JUST KILL YOURSELF";
		
	}
	@Override
	public Image getImage(){
		return img;
	}
	public Dialogue getPrompt(Character x, boolean shouldChange){
		if(shouldChange){
			if(position <4)
			{
				if(position == 0)
					x.decreaseHappiness(15);
				else if(position == 1)
					x.decreaseHappiness( 25);
				else if(position == 2)
					x.decreaseHappiness(35);
				else if(position == 3)
					x.decreaseHappiness(45);
				return new Dialogue("You have 1 new Message: " + 
						meanComments[position++] + "\n Your happiness has now decreased");
			}
		}
		return new Dialogue("");
	}
	/**
	 * 
	 * @return a happiness value from a comment
	 */
	public int postOnline(){
		int sign = -1;
		if(Math.random() < 0.2) sign = 1;
		return (int) Math.random() * 10 * sign;
	}
	public String getMeanComment(){
		return meanComments[(int) Math.random() * 4];
	}
	public String getNiceComment(){
		return niceComments[(int) Math.random() * 2];
	}
	
}
