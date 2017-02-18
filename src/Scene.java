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
    private ArrayList<Box> boxes;
    private final int DELAY = 10;
    public static final int BOARD_MAX_X = 640;
    public static final int BOARD_MAX_Y = 640;


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
        boxes = new ArrayList<Box>();
        boxes.add(new Box(400, 400));

        timer = new Timer(DELAY, this);
        timer.start();        
    }

    /*
    Returns array list of boxes
    */
    public ArrayList<Box> getBoxes() {
        return this.boxes;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
        
        //draw boxes
        for(Box box : boxes) {
            g2d.drawImage(box.getImage(), box.getX(), box.getY(), this);
        }
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        character.move(this.boxes);
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            character.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            character.keyPressed(e);
        }
    }
}
