package aircraft;

import items.*;

public class Mario extends Aircraft {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/2wX6akd.gif";


	public Mario(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(1, 1, 200, 100, imagePath);
	}

	@Override
	public void move() {
		this.setVelocityX(this.getVelocityX() + this.getAccelerationX());
		this.setPositionX(this.getPositionX() + this.getVelocityX());
		this.setPositionY(this.getPositionY() + this.getVelocityY());
		this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
		relocatePositionIfNeed();
	}
	
	@Override
	public void relocatePositionIfNeed() {
		if(this.getPositionX() > 220) {
			this.setPositionX(-500);
		}
	}

}
