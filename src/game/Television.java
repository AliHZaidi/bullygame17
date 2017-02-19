package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Television extends NonPlayableObject {
	private Image img;
	int times;
	public Television(String z, int x, int y){
		super(new ImageIcon(z).getImage(),x,y);
		img = new ImageIcon(z).getImage();
		times = 0;
	}
	
	public Image getImage(){
		return img;
	}
	
	public Dialogue getPrompt(Character x){
		if(times == 0)
		{
			times++;
			x.increaseHappiness(5);
			return new Dialogue("You watch some tv and " + 
			  "\n your happiness has now increased by 5");
		}
			return new Dialogue("Sorry, the TV is broken" +
					"\n ,maybe go look at your computer");
		
		
	}
	
}
