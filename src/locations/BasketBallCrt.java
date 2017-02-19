/**
 * 
 */
package locations;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import game.Basketball;
import game.Box;
import game.NonPlayableObject;

/**
 * @author Matt
 *
 */
public class BasketBallCrt extends Location {
	
	public BasketBallCrt(){
		super.map = new ArrayList<NonPlayableObject>();
        super.background = new ImageIcon("basketball_court.png").getImage();
        
        map.add(new Basketball(new ImageIcon("basketball.png").getImage(), 150, 300));
	}

	/* (non-Javadoc)
	 * @see locations.Location#getLeft()
	 */
	@Override
	public Location getLeft() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see locations.Location#getRight()
	 */
	@Override
	public Location getRight() {
		return new Outside();
	}

	/* (non-Javadoc)
	 * @see locations.Location#getTop()
	 */
	@Override
	public Location getTop() {
		return null;
	}

	/* (non-Javadoc)
	 * @see locations.Location#getBottom()
	 */
	@Override
	public Location getBottom() {
		return null;
	}

}
