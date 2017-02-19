/**
 * 
 */
package game;

import java.awt.Image;

/**
 * @author Matt
 *
 */
public class Basketball extends NonPlayableObject {
	private int i;
	/**
	 * @param image
	 * @param x
	 * @param y
	 */
	public Basketball(Image image, int x, int y) {
		super(image, x, y);
		i = 0;
		
	}
	
	public Dialogue getPrompt(Character x, boolean shouldChange){
		int amount = 20 -i;
		if(shouldChange){

			x.increaseHappiness(amount);
			if(i < 20)
				i += 5;
		}
		if(i<20)
		return new Dialogue("You play some basketball, but after playing, it seems more boring"
				+ "\nYour Happiness Increases by: " + amount);
			return new Dialogue("Basketball no longer seems fun." + 
				"\n Maybe look at your computer.");
	}

}
