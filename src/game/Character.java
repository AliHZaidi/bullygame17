package game;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import locations.Location;

public class Character {
	
    private int dx;
    private int dy;
    private int speed;
    private int x;
    private int y;
    private ArrayList<Image> fronts;
    private ArrayList<Image> backs;
    private ArrayList<Image> rSides;
    private ArrayList<Image> lSides;
    
    private Image curImage;
    private String name;
    private ArrayList<String> imgFileNames;

    //current location of the character
    private Location location;
    
    private boolean upIsPressed = false;
    private boolean downIsPressed = false;
    private boolean leftIsPressed = false;
    private boolean rightIsPressed = false;
    
    private NonPlayableObject nearbyObj;
    
    private long curTime;
    
    private boolean changeImg;
    
    private ArrayList<Image> curImages;
    
    private double timeSinceOR;
    
    private Integer frontsCurIx;
    private Integer backsCurIx;
    private Integer rSidesCurIx;
    private Integer lSidesCurIx;
    
    private Dialogue curText;
    
	private int happiness;
    
    private Integer currCurrIx;
    
    // 0 Index stores the orientation counter for the front, 1 index for back
    // 2 index for right, 3 index for left
    private short[] curORIxs;
    
    private short curCurORIxs;
    
    public Character(String name) {
    	
    	timeSinceOR = 0;
    	curTime = System.currentTimeMillis();
    	happiness = 100;
    	
    	curORIxs = new short[4];
    	for(int i = 0; i < curORIxs.length; ++i){
    		curORIxs[i] = 0;
    	}
    
    	frontsCurIx = new Integer(0);
    	backsCurIx = new Integer(0);
        rSidesCurIx = new Integer(0);
        lSidesCurIx = new Integer(0);

        speed = 2;

        fronts = new ArrayList<Image>();
        backs = new ArrayList<Image>();
        lSides = new ArrayList<Image>();
        rSides = new ArrayList<Image>();
        this.name = name;
        imgFileNames = new ArrayList<String>();
        File curFolder = new File("./");
        File[] files = curFolder.listFiles();
        for(int i = 0; i < files.length; ++i){
        	if(files[i].getName().contains(".png")){
        		imgFileNames.add(files[i].getName());
        	}
        }

        x = Scene.SCENE_MAX_X / 2;
        y = Scene.SCENE_MAX_Y / 2;
        
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
    	curImages = fronts;
        curImage = fronts.get(0);
        curCurORIxs = 0;
        x = 40;
        y = 60;
    }
    
    public void decreaseHappiness(int amount){
    	happiness -= amount;
    }
    public void increaseHappiness(int amount){
    	happiness += amount;
    }
    public void decreaseHappiness(){
    	--happiness;
    }
    public void increaseHappiness(){
    	++happiness;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location l) {
        this.location = l;
    }


    public void move() {
    	

        if(!collison(x+dx, y+dy, this.location.getMap())) {
            x += dx*speed;
    	    y += dy*speed;
        }
    	
        //check if character has left location if so 
    	if (this.x < 0 || this.x > 630 || this.y < 0 || this.y > 640) leave();
    }

    private void leave() {

        
        
        //Leave left
        if(this.x < 0) {
            this.x = 630;
            this.location = this.location.getLeft();
        }

        //Leave right 
        if(this.x > 640) {
            this.x = 10;
            this.location = this.location.getRight();
        } 

        //Leave top
        if(this.y < 0) {
            this.y = 630;
            this.location = this.location.getTop();
        } 

        //Leave bottom
        if(this.y > 640) {
            this.y = 10;
            this.location = this.location.getBottom();
        } 

    }
    
    /*
    Takes an x and y coord and checks for overlap with block object
    */
    private boolean collison(int x, int y, ArrayList<NonPlayableObject> arrayList) {
        for(NonPlayableObject npo : arrayList) {
            if(( x + 32 > npo.getX() && x < npo.getX() + 32) 
            		&& (y + 32 > npo.getY() && y < npo.getY() + 32)) return true;
        }

        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Dialogue getInteractText(){
    	return curText;
    }

    public Image getImage() {
    	timeSinceOR += System.currentTimeMillis() - curTime;
    	if(changeImg){
    		
        	if(timeSinceOR > 200){
            	curImage = curImages.get(curORIxs[curCurORIxs]);
            	if(curORIxs[curCurORIxs] >= curImages.size() - 1){
            		curORIxs[curCurORIxs] = 0;
            	}else if(curImages.size() > 1){
            		++curORIxs[curCurORIxs];
            	}
            	
            }
        	
    	}else{
    		curImage = curImages.get(0);
    	}
    	if(timeSinceOR > 200) timeSinceOR = 0;
    	else curTime = System.currentTimeMillis();
        return curImage;
    }

    public void keyPressed(KeyEvent e, ArrayList<NonPlayableObject> arrayList) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE && this.isNearNPC(arrayList)) {
        	if(nearbyObj instanceof Computer){
        		curText = ((Computer) nearbyObj).getPrompt(this);
        	}else if(nearbyObj instanceof Basketball){
        		curText = ((Basketball) nearbyObj).getPrompt(this);
        	}
        	else if(nearbyObj instanceof Television)
        		curText = ((Television) nearbyObj).getPrompt(this);
        }
        
        else if (key == KeyEvent.VK_LEFT && !upIsPressed && !downIsPressed) {
            dx = -1;
            leftIsPressed = true;
            curImages = lSides;
            changeImg = true;
            curCurORIxs = 3;
        }

        else if (key == KeyEvent.VK_RIGHT && !upIsPressed && !downIsPressed) {
            dx = 1;
            rightIsPressed = true;
            curImages = rSides;
            changeImg = true;
            curCurORIxs = 2;
        }

        else if (key == KeyEvent.VK_UP && !leftIsPressed && !rightIsPressed) {
            dy = -1;
            upIsPressed = true;
            curImages = backs;
            changeImg = true;
            curCurORIxs = 1;
        }

        else if (key == KeyEvent.VK_DOWN && !leftIsPressed && !rightIsPressed) {
            dy = 1;
            downIsPressed = true;
            curImages = fronts;
            changeImg = true;
            curCurORIxs = 0;
        }
    }

    public void keyReleased(KeyEvent e) {       
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            leftIsPressed = false;
            changeImg = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            rightIsPressed = false;
            changeImg = false;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            upIsPressed = false;
            changeImg = false;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            downIsPressed = false;
            changeImg = false;
        }

    }

	/**
	 * @return
	 */
	public int getHappiness() {
		return happiness;
	}
    

    private boolean isNearNPC(ArrayList<NonPlayableObject> arrayList) {
    	for (NonPlayableObject npo : arrayList) {
            if ((x + 40 > npo.getX() && x < npo.getX() + 40) && (y + 40 > npo.getY() && y < npo.getY() + 40)) {
            	nearbyObj = npo;
            	return true;
            }
        }
    	nearbyObj = null;
    	return false;
    }
    
    
}