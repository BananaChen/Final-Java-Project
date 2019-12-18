package person;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import items.*;

public class Thug extends Person {

	private static final long serialVersionUID = -1233480500986673884L;
	
	public JLabel heart1;
	public JLabel heart2;
	public JLabel heart3;
	public JLabel lbSunGlasses;
	public Timer timer;
	
	public Thug(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		
		imageWidth = 100;
		imageHeight = 100;
		
		setImage(x, y, imageWidth, imageHeight, "https://image.flaticon.com/icons/png/512/72/72924.png");
		
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/uSpGrlw.png"));
			icon.setImage(icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			lbSunGlasses = new JLabel(icon);
			lbSunGlasses.setLocation((int) 0, (int) 10);
			lbSunGlasses.setSize(imageWidth, imageHeight);
			lbSunGlasses.setLayout(null);
			lb.add(lbSunGlasses);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/dvVH6wA.png"));
			icon.setImage(icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			heart1 = new JLabel(icon);
			heart1.setLocation((int) 0, (int) 0);
			heart1.setSize(imageWidth/3, imageWidth/3);
			heart1.setLayout(null);
			lb.add(heart1);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/dvVH6wA.png"));
			icon.setImage(icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			heart2 = new JLabel(icon);
			heart2.setLocation((int) imageWidth/3, (int) 0);
			heart2.setSize(imageWidth/3, imageWidth/3);
			heart2.setLayout(null);
			lb.add(heart2);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/dvVH6wA.png"));
			icon.setImage(icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			heart3 = new JLabel(icon);
			heart3.setLocation((int) imageWidth*2/3, (int) 0);
			heart3.setSize(imageWidth/3, imageWidth/3);
			heart3.setLayout(null);
			lb.add(heart3);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	public void move() {
		switch (blood) {
		case 3:
			heart1.setVisible(true);
			heart2.setVisible(true);
			heart3.setVisible(true);
			break;
		case 2:
			heart1.setVisible(true);
			heart2.setVisible(true);
			heart3.setVisible(false);
			break;
		case 1:
			heart1.setVisible(true);
			heart2.setVisible(false);
			heart3.setVisible(false);
			break;
		case 0:
			heart1.setVisible(false);
			heart2.setVisible(false);
			heart3.setVisible(false);
			break;
		}
		
		this.velocityX += this.accelerationX;
		this.velocityY += this.accelerationY;
		this.positionX += this.velocityX;
		this.positionY += this.velocityY;
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}
}