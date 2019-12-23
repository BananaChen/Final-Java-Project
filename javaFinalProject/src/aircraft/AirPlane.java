package aircraft;


import items.*;

public class AirPlane extends Aircraft {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/9HrrZCt.png";

	public AirPlane(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(1, 1, 300, 150, imagePath);
	}

	@Override
	public void move() {
		this.velocityX += this.accelerationX;
		this.positionX += this.velocityX;
		this.setLabelLocation((int) this.positionX, (int) this.positionY);
		
		relocatePositionIfNeed();
	}
	
	
}