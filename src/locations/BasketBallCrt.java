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
        for(int i = 0; i <= 20; i++) {
            super.map.add(new Box(new ImageIcon("box.png").getImage(),i, -1));
        }
        for(int i = 0; i <= 20; i++) {
            super.map.add(new Box(new ImageIcon("box.png").getImage(),i, 20));
        }
        for(int i = 0; i <= 20; i++) {
            super.map.add(new Box(new ImageIcon("box.png").getImage(),-1, i));
        }
        map.add(new Basketball(new ImageIcon("basketball.png").getImage(), 150, 300));
	}

	/* (non-Javadoc)
	 * @see locations.Location#getLeft()
	 */
	@Override
	public String getLeft() {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see Strings.String#getRight()
	 */
	@Override
	public String getRight() {
		return "outside";
	}

	/* (non-Javadoc)
	 * @see Strings.String#getTop()
	 */
	@Override
	public String getTop() {
		return null;
	}

	/* (non-Javadoc)
	 * @see Strings.String#getBottom()
	 */
	@Override
	public String getBottom() {
		return null;
	}

}
