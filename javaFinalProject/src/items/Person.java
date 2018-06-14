package items;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Person extends Items {

	private String imagePath = "https://image.flaticon.com/icons/png/512/72/72924.png";
	public boolean isDropped = false;

	public double personInitPx = 0;
	public double personInitPy = 0;
	public double personInitVx = 0;
	public double personInitVy = 0;
	public double personInitAx = 0;
	public double personInitAy = 0;

	// for Jared only
	public JLabel heart1;
	public JLabel heart2;
	public JLabel heart3;
	public JLabel lbSunGlasses;
	public double gx;
	public double gy = 1000;
	public int blood = 3;
	public Timer timer;

	public Person(double x, double y, double vx, double vy, double ax, double ay) {
		super();
		setInitMoveData(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 100, imagePath);
	}

	public void setInitMoveData(double x, double y, double vx, double vy, double ax, double ay) {
		personInitVx = vx;
		personInitVy = vy;
		personInitAx = ax;
		personInitAy = ay;
	
	}

	@Override
	public void move() {
		//System.out.print("m");
		this.velocityX += this.accelerationX;
		this.velocityY += this.accelerationY;
		this.positionX += this.velocityX;
		this.positionY += this.velocityY;
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}

}