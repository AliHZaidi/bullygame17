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
	
	public Dialogue getPrompt(Character x){
		int amount = 20 -i;
		x.increaseHappiness(amount);
		i -= 5;
		return new Dialogue("You play some basketball, but after playing it seems more boring"
				+ "\nYour Happiness Increases by: " + amount);
	}

}
