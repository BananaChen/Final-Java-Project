package items;

import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class Items extends JPanel {

	public JLabel lb;
	public int imageWidth;
	public int imageHeight;
	public int labelWide;
	public int labelLength;

	public double positionX = 0;
	public double positionY = 0;
	public double velocityX = 0;
	public double velocityY = 0;
	public double accelerationX = 0;
	public double accelerationY = 0;
	
	public Items() {
		
	}

	public Items(double x, double y, double vx, double vy, double ax, double ay) {
		setMoveData(x, y, vx, vy, ax, ay);
	}
	
	public void setImage(double x, double y, int wide, int length, String imagePath) {
		try {
			ImageIcon icon = new ImageIcon(new URL(imagePath));
			icon.setImage(icon.getImage().getScaledInstance(wide, length, Image.SCALE_DEFAULT));
			lb = new JLabel(icon);
			lb.setLocation((int) x, (int) y);
			lb.setSize(wide, length);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		imageWidth = wide;
		imageHeight = length;
	}
	
	public void setMoveData(double x, double y, double vx, double vy, double ax, double ay) {
		setPositionX(x);
		setPositionY(y);
		setVelocityX(vx);
		setVelocityY(vy);
		setAccelerationX(ax);
		setAccelerationY(ay);
	}

	public void setPositionX(double x) {
		positionX = x;
	}

	public void setPositionY(double y) {
		positionY = y;
	}

	public void setVelocityX(double vx) {
		velocityX = vx;
	}

	public void setVelocityY(double vy) {
		velocityY = vy;
	}

	public void setAccelerationX(double ax) {
		accelerationX = ax;
	}

	public void setAccelerationY(double d) {
		accelerationY = d;
	}

	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public double getVelocityX() {
		return velocityX;
	}

	public double getVelocityY() {
		return velocityY;
	}

	public double getAccelerationX() {
		return accelerationX;
	}

	public double getAccelerationY() {
		return accelerationY;
	}

	public void move() {
		setPositionX(getPositionX() + getVelocityX());
		setPositionY(getPositionY() + getVelocityY());
	}

	public void acceleration(int ax, int ay) {
		setAccelerationX(getAccelerationX() + ax);
		setAccelerationY(getAccelerationX() + ay);
	}

	//public abstract void collideEvent(); // object 碰撞時的事件

	// public abstract void effect(ArrayList<Person> persons); // disturbance 的影響

}