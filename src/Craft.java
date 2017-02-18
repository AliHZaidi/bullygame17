import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Craft {
	

    private int dx;
    private int dy;
    private int x;
    private int y;
    private ArrayList<Image> fronts;
    private ArrayList<Image> backs;
    private ArrayList<Image> rSides;
    private ArrayList<Image> lSides;
    
    private boolean upIsPressed = false;
    private boolean downIsPressed = false;
    private boolean leftIsPressed = false;
    private boolean rightIsPressed = false;
    
    private Image curImage;
    private String name;
    private ArrayList<String> imgFileNames;

    public Craft(String name) {

        fronts = new ArrayList<Image>();
        backs = new ArrayList<Image>();
        lSides = new ArrayList<Image>();
        rSides = new ArrayList<Image>();
        this.name = name;
        imgFileNames = new ArrayList<String>();
        File curFolder = new File("./");
        File[] files = curFolder.listFiles();
        System.out.println(files.length);
        for(int i = 0; i < files.length; ++i){
        	if(files[i].getName().contains(".png")){
        		imgFileNames.add(files[i].getName());
        	}
        }
        initCraft();
    }
    
    private void initCraft() {
        x = Board.BOARD_MAX_X / 2;
        y = Board.BOARD_MAX_Y / 2;
        
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


    public void move() {
    	
    	x += dx;
    	y += dy;
    	
    	if (x <= 10) {
    		x = 10;
    	}
    	else if (x >= Board.BOARD_MAX_X - 64) {
    		x = Board.BOARD_MAX_X - 64;
    	}
    	
    	if (y <= 10) {
    		y = 10;
    	}
    	else if (y >= Board.BOARD_MAX_Y - 96) {
    		y = Board.BOARD_MAX_Y - 96;
    	}
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

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            leftIsPressed = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            rightIsPressed = true;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            upIsPressed = true;
        }

        if (key == KeyEvent.VK_DOWN) {
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
}