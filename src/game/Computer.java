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
	public Computer(Image img, int x, int y){
		super(img,x, y);
		this.img = img;
		
		meanComments = new String[5];
		meanComments[0] = "Wow that's so dumb! UR AN IDIOT XD";
		meanComments[1] = "Yo mama so fat she fell in the grand canyon and got stuck!";
		meanComments[2] = "ur so ugly that when u tried to join an ugly contest they said, "
							+ "\"Sorry, no professionals.\"";
		meanComments[3] = "You should go die!";
		meanComments[4] = "this is SO lame :/";
		
		niceComments = new String[3];
		niceComments[0] = "Wow that's so cool! Good for you!";
		niceComments[1] = "I really look up to you, wanna hang out sometime?";
		niceComments[2] = "Have a great day! Really enjoyed reading that :)";
		
	}
	@Override
	public Image getImage(){
		return img;
	}
	public String getPrompt(){
		return "Would you like to: /n"
				+ "1) Play a computer game\n"
				+ "2) Do homework\n"
				+ "3) Post Online\n";
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
