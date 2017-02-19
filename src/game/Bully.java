/**
 * 
 */
package game;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import locations.Location;
import locations.School;

/**
 * @author Matt
 *
 */
public class Bully extends NonPlayableObject {

	private ArrayList<String> imgFileNames;
	private double timeSinceOR;
	private boolean changeImg;
	private short[] curORIxs;
	private short curCurORIxs;
	private ArrayList<Image> curImages;
	private Image curImage;
	private long curTime;
	private int speed;
	private int dx;
	private int dy;
	private int curDirection;
	private Location location;
	private ArrayList<Image> fronts;
    private ArrayList<Image> backs;
    private ArrayList<Image> rSides;
    private ArrayList<Image> lSides;
    private long lastDirChange;
    private long lastItr;
    private Random rand;
	/**
	 * @param image
	 * @param x
	 * @param y
	 */
	public Bully(Image image, int x, int y) {
		super(image, x, y);
		timeSinceOR = 0;
    	curTime = System.currentTimeMillis();
    	curORIxs = new short[4];
    	for(int i = 0; i < curORIxs.length; ++i){
    		curORIxs[i] = 0;
    	}
    	fronts = new ArrayList<Image>();
        backs = new ArrayList<Image>();
        lSides = new ArrayList<Image>();
        rSides = new ArrayList<Image>();
    	String name = "bully";
    	speed = 1;
    	imgFileNames = new ArrayList<String>();
        File curFolder = new File("./");
        File[] files = curFolder.listFiles();
        for(int i = 0; i < files.length; ++i){
        	if(files[i].getName().contains(".png")){
        		imgFileNames.add(files[i].getName());
        	}
        }
        for(String e : imgFileNames){
        	if(e.contains("back") && e.contains(name)){
        		backs.add((new ImageIcon(e).getImage()));
        	}
        }
    	for(String e : imgFileNames){
        	if(e.contains("front") && e.contains(name)){
        		fronts.add((new ImageIcon(e).getImage()));
        	}
        }
    	for(String e : imgFileNames){
        	if(e.contains("left_side") && e.contains(name)){
        		lSides.add((new ImageIcon(e).getImage()));
        	}
        }
    	for(String e : imgFileNames){
        	if(e.contains("right_side") && e.contains(name)){
        		rSides.add((new ImageIcon(e).getImage()));
        	}
        }
    	
    	rand = new Random(2222);
    	lastDirChange = 0;
    	lastItr = System.currentTimeMillis();
    	curImages = fronts;
    	curImage = fronts.get(0);
	}

	public Dialogue getPrompt(Character x, boolean shudChange){
		if(shudChange){
			x.decreaseHappiness(20);
		}
		return new Dialogue("The bully says: Give me your lunch money LOSER!"
				+ "\nYour happiness decreases");
	}
	
	
	public Image getImage() {
    	return curImage;
	}

}
