import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Craft {

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    private int currentDirection = 0;
    
    public Craft() {
        initCraft();
    }
    
    private void initCraft() {
        ImageIcon ii = new ImageIcon("images/sprites/blue knight.png");
        image = ii.getImage();
        
        x = Board.BOARD_MAX_X / 2;
        y = Board.BOARD_MAX_Y / 2;       
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
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
            currentDirection = KeyEvent.VK_LEFT;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
            currentDirection = KeyEvent.VK_RIGHT;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
            currentDirection = KeyEvent.VK_UP;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
            currentDirection = KeyEvent.VK_DOWN;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}