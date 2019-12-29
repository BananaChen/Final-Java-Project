package aircraft;


import items.*;
import windows.Scene;

public class RollerCoaster extends Aircraft {

	private static final long serialVersionUID = 1L;
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

		this.setVelocityX((-1) * Math.sin(radians));
		this.setVelocityY((-1) * Math.cos(radians));

		if (this.getPositionX() > 0) {
			this.setPositionX(firstX - 60 * Math.cos(radians) + dif);
			this.setPositionY(firstY - 60 * Math.sin(radians));
			this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
		} else {
			dif = 0;
			firstX = Scene.bgWidth;
			this.setPositionX(Scene.bgWidth);
		}
	}
}