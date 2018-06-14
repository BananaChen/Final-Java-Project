package aircraft;


import items.*;
import windows.Scene;

public class RollerCoaster extends Aircraft {

	private String imagePath = "https://i.imgur.com/2CToQ7a.png";
	double degrees;
	double dif;
	double firstX;
	double firstY;

	public RollerCoaster(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(1, 1, 100, 100, imagePath);
		degrees = ax - 2;
		firstX = x;
		firstY = y;
		dif = 0;
	}

	@Override
	public void move() {
		// this.valocityX += this.accelerationX;
		dif -= 3;
		degrees -= 2;
		double radians = Math.toRadians(degrees);

		this.velocityX = (-1) * Math.sin(radians);
		this.velocityY = (-1) * Math.cos(radians);

		if (this.positionX > 0) {
			this.positionX = firstX - 60 * Math.cos(radians) + dif;
			this.positionY = firstY - 60 * Math.sin(radians);
			this.lb.setLocation((int) this.positionX, (int) this.positionY);
		} else {
			dif = 0;
			firstX = Scene.bgWidth;
			this.positionX = Scene.bgWidth;
		}
	}
}