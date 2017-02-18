import java.awt.Image;
//import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.concurrent.*;



public class npc {
	    private int x;
	    private int y;
	    private Image image;

	    public npc() {
	        
	        initNpc();
	    }
	    
	    private void initNpc() {
	        
	        ImageIcon ii = new ImageIcon("craft.png");
	        image = ii.getImage();
	        x = 800;
	        y = 150;        
	    }


	    public void move() {
	     
	      //int z = (int)(Math.random()*2);
	      //if(z == 0)
	      //{
	    	 // x = x+10;
	    	 // y = y+10;
	      //}
	      //else
	      //{
	    	//  x= x-10;
	    	//  y = y-10;
	      //}
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
	    
}



