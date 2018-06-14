package person;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import items.*;

public class Thug extends Person implements ActionListener {

	private static final long serialVersionUID = -1233480500986673884L;
	
	
	public Thug(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		
		imageWidth = 100;
		imageHeight = 100;
		
		timer = new Timer(10, this);
		setImage(x, y, imageWidth, imageHeight, "https://image.flaticon.com/icons/png/512/72/72924.png");
		
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/uSpGrlw.png"));
			icon.setImage(icon.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			lbSunGlasses = new JLabel(icon);
			lbSunGlasses.setLocation((int) 0, (int) 0);
			lbSunGlasses.setSize(imageWidth, imageHeight);
			lbSunGlasses.setLayout(null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/dvVH6wA.png"));
			icon.setImage(icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			heart1 = new JLabel(icon);
			heart1.setLocation((int) x, (int) y);
			heart1.setSize(imageWidth/3, imageWidth/3);
			heart1.setLayout(null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/dvVH6wA.png"));
			icon.setImage(icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			heart2 = new JLabel(icon);
			heart2.setLocation((int) x/3, (int) y);
			heart2.setSize(imageWidth/3, imageWidth/3);
			heart2.setLayout(null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			ImageIcon icon = new ImageIcon(new URL("https://i.imgur.com/dvVH6wA.png"));
			icon.setImage(icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
			heart3 = new JLabel(icon);
			heart3.setLocation((int) x*2/3, (int) y);
			heart3.setSize(imageWidth/3, imageWidth/3);
			heart3.setLayout(null);
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
		this.heart1.setLocation((int) this.positionX, (int) this.positionY-30);
		this.heart2.setLocation((int) this.positionX+imageWidth/3, (int) this.positionY-30);
		this.heart3.setLocation((int) this.positionX+imageWidth*2/3, (int) this.positionY-30);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// put on sunglasses
		if (gy > this.positionY + 10) {
			this.gy -= 2;
			lbSunGlasses.setLocation((int) this.gx, (int) this.gy);
		} else
			timer.stop();
	}
}