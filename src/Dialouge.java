import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Dialouge {


    private String text;

    Dialouge(String input) {
        text = input;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(102,51,0));
        g2d.fillRoundRect(10, 550, 620, 80, 25, 25);
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(20, 560, 600, 60, 25, 25);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Test", 30, 600);
    }
}