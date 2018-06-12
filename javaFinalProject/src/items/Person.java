package items;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Person extends Items {

	private String imagePath = "https://image.flaticon.com/icons/png/512/72/72924.png";
	public boolean isDropped = false;
	
	//for Jared only
	public JLabel lbThugLife;
	public double gx;
	public double gy = 1000;
	public int blood = 3;
	public Timer timer;
	
	public Person(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 100, imagePath);
	}

	@Override
	public void move() {
		this.velocityX += this.accelerationX;
		this.velocityY += this.accelerationY;
		this.positionX += this.velocityX;
		this.positionY += this.velocityY;
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}

	public void collideIsland() {
		setVelocityX(0);
		setVelocityY(0);
		setAccelerationX(0);
		setAccelerationY(0);
	}

	public void collideOcean() {
		setVelocityX(0);
		setVelocityY(0);
		setAccelerationX(0);
		setAccelerationY(0);
	}

	public void effect() {

	}

}