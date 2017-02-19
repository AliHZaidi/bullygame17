import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Character {
	
    private int dx;
    private int dy;
    private int x;
    private int y;
    private ArrayList<Image> fronts;
    private ArrayList<Image> backs;
    private ArrayList<Image> rSides;
    private ArrayList<Image> lSides;
    
    private Image curImage;
    private String name;
    private ArrayList<String> imgFileNames;
    
    private boolean upIsPressed = false;
    private boolean downIsPressed = false;
    private boolean leftIsPressed = false;
    private boolean rightIsPressed = false;
    
    public Character(String name) {

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
        initCraft();
    }
    
    private void initCraft() {
        x = Scene.BOARD_MAX_X / 2;
        y = Scene.BOARD_MAX_Y / 2;
        
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
        curImage = fronts.get(0);
        x = 40;
        y = 60;
    }


    public void move(ArrayList<Box> boxes) {
        if(!collison(x+dx, y+dy, boxes)) {
            x += dx;
    	    y += dy;
        }
    	
    	if (x <= 10) {
    		x = 10;
    	}
    	else if (x >= Scene.BOARD_MAX_X - 64) {
    		x = Scene.BOARD_MAX_X - 64;
    	}
    	
    	if (y <= 10) {
    		y = 10;
    	}
    	else if (y >= Scene.BOARD_MAX_Y - 96) {
    		y = Scene.BOARD_MAX_Y - 96;
    	}
    }
    
    /*
    Takes an x and y coord and checks for overlap with block object
    */
    private boolean collison(int x, int y, ArrayList<Box> boxes) {
        for(Box b : boxes) {
            if(( x + 32 > b.getX() && x < b.getX() + 32) && (y + 32 > b.getY() && y < b.getY() + 32)) return true;
        }

        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return curImage;
    }

    public void keyPressed(KeyEvent e, ArrayList<Box> boxes) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE && this.isNearNPC(boxes)) {
        	System.out.println("hell yeah d00d");
        }
        
        else if (key == KeyEvent.VK_LEFT && !upIsPressed && !downIsPressed) {
            dx = -1;
            leftIsPressed = true;
        }

        else if (key == KeyEvent.VK_RIGHT && !upIsPressed && !downIsPressed) {
            dx = 1;
            rightIsPressed = true;
        }

        else if (key == KeyEvent.VK_UP && !leftIsPressed && !rightIsPressed) {
            dy = -1;
            upIsPressed = true;
        }

        else if (key == KeyEvent.VK_DOWN && !leftIsPressed && !rightIsPressed) {
            dy = 1;
            downIsPressed = true;
        }
        
        updateSprite();
    }

    public void keyReleased(KeyEvent e) {       
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            leftIsPressed = false;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            rightIsPressed = false;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            upIsPressed = false;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            downIsPressed = false;
        }
        
        updateSprite();
    }
    
    private void updateSprite() {
    	if (upIsPressed) {
    		curImage = backs.get(0);
    	}
    	else if (downIsPressed) {
    		curImage = fronts.get(0);
    	}
    	else if (leftIsPressed) {
    		curImage = lSides.get(0);
    	}
    	else if (rightIsPressed) {
            curImage = rSides.get(0);
    	}
    }
    
    private boolean isNearNPC(ArrayList<Box> boxes) {
    	for (Box b : boxes) {
            if ((x + 40 > b.getX() && x < b.getX() + 40) && (y + 40 > b.getY() && y < b.getY() + 40)) {
            	return true;
            }
        }
    	
    	return false;
    }
}