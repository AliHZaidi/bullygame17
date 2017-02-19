package game;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import locations.*;



import java.util.ArrayList;


public class Scene extends JPanel implements ActionListener {
	private Timer timer;
	private Character character;
	private final int DELAY = 10;
	public static final int SCENE_MAX_X = 640;
	public static final int SCENE_MAX_Y = 640;

	private int creditcounter = 0;

	private Location currentLocation;

	private boolean startScreen;

	public Scene() {
		addKeyListener(new TAdapter());
		setFocusable(true);
		setBackground(Color.WHITE);

		character = new Character("hero");
		
		// set text initial tutorial dialogue
		character.setInteractText(new Dialogue("You awaken in your room.\nPress space to interact with some objects."));
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
		
		if (character.isMovingAtAll()) {
			character.setInteractText(null);
		}

		Graphics2D g2d = (Graphics2D) g;

		if(startScreen) {
			ImageIcon ii = new ImageIcon("Splash.png");
			g2d.drawImage(ii.getImage(),0,0,this);

		} else if (character.getHappiness() > 0) { 
			g2d.setFont(new Font("Dialog", 0, 14));
			Location curL = character.getLocation();
			curL.draw(g, this);

			if(character.getInteractText() != null){
				Dialogue dlg = character.getInteractText();
				dlg.draw(g2d);
			}
			g2d.setFont(new Font("Dialog", 0, 24));

			g2d.drawImage(character.getImage(), character.getX(), character.getY(), this);
			//Draw score
			g2d.setColor(Color.WHITE);
			g2d.fillRoundRect(520, 15, 100, 40, 25, 25);
			g2d.setColor(Color.BLACK);
			g2d.drawString("☺ " + character.getHappiness(), 530, 43);
		}


		else{
			creditcounter++;
			if(creditcounter <750)
			{
				g2d.drawImage(new ImageIcon("credit1.png").getImage(),0,0,this);

			}

			if(creditcounter<1500 && creditcounter> 751)
			{
				ImageIcon a =new ImageIcon("credit2.png");
				g2d.drawImage(a.getImage(),0,0,this);
			}

			if(creditcounter >1501 && creditcounter < 2250)
			{
				g2d.drawImage(new ImageIcon("credit3.png").getImage(),0,0,this);
			}

			if(creditcounter > 2251 )
			{
				g2d.drawImage(new ImageIcon("credit4.png").getImage(),0,0,this);
			}
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		character.move();
		repaint();  
	}

	private class TAdapter extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {

			if(startScreen && e.getKeyCode() == KeyEvent.VK_SPACE) {
				startScreen = false;
			}

			character.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			character.keyPressed(e, character.getLocation().getMap());
		}
	}
}
