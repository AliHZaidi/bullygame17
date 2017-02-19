package game;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Dialogue {

    private String text;

    Dialogue(String input) {
        text = input;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(102,51,0));
        g2d.fillRoundRect(10, 550, 620, 80, 25, 25);
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(20, 560, 600, 60, 25, 25);
        g2d.setColor(Color.BLACK);
        if(text.length() > 80 || text.contains("\n")){
        	g2d.drawString(this.text.split("\n")[0], 31, 585);
        	g2d.drawString(this.text.split("\n")[1], 30, 600);
        }else{
        	g2d.drawString(this.text, 30, 600);
        }
        
    }
}