package aircraft;


import items.*;

public class AirPlane extends Aircraft {

	private String imagePath = "https://i.imgur.com/9HrrZCt.png";

	public AirPlane(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(1, 1, 300, 150, imagePath);
	}

	@Override
	public void move() {
		this.velocityX += this.accelerationX;
		this.positionX += this.velocityX;
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}
}