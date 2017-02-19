package game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Television extends Box {
	private Image img;
	private String[] niceComments;
	public Television(int x, int y){
		super(x,y);
		img = new ImageIcon("Television.png").getImage();
		niceComments = new String[3];
		niceComments[0] = "This just in, the Badgers win the Championship";
		niceComments[1] = "This just in, world hunger is gone";
		niceComments[2] = "This just in, Messages Matter wins MadHacks";
	}
	
	public Image getImage(){
		return img;
	}
	
	public String getPrompt(){
		return "Would you like to: /n"
				+ "1) Watch some TV\n" ;
	}
	
	public String getNiceComment(){
		return niceComments[(int) Math.random() * 3];
	}
	
}
