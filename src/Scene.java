import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;


public class Scene extends JPanel implements ActionListener {

    private Timer timer;
    private Character character;
    private final int DELAY = 10;
    public static final int BOARD_MAX_X = 640;
    public static final int BOARD_MAX_Y = 640;

    private Location currentLocation;


    public enum Locations  {
        HOME, OUTDOOR, SCHOOL
    }
    private boolean startScreen;


    public ArrayList<Integer> keysPressed;

    public Scene() {

        initBoard();
    }
    
    private void initBoard() {

        keysPressed = new ArrayList<Integer>();
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);

        character = new Character("bully");
        
        //Add boxes, this will eventually be loaded from some sort of map
        currentLocation = new Home();
        
        startScreen = true;

        timer = new Timer(DELAY, this);
        timer.start();        
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
       
       if(startScreen) {

       } else {
             g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
             currentLocation.draw(g, this);
    
       }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        character.move(currentLocation.getMap());
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            
            if(startScreen && e.getKeyCode() == KeyEvent.VK_SPACE) {
                System.out.println("Space pressed");
                startScreen = false;
            }
            
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }
    }
}
