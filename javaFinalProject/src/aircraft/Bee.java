package aircraft;


import items.Aircraft;

public class Bee extends Aircraft {

	private static final long serialVersionUID = 4264599267255689468L;
	public int time = 0;

	public Bee(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 150;
		imageHeight = 150;
		setImage(x, y, imageWidth, imageHeight, imagePath);
	}

	@Override
	public void move() {

		this.setVelocityX(this.getVelocityX() + this.getAccelerationX());
		this.setVelocityY(this.getVelocityY() + this.getAccelerationY());

		if (Math.random() * 2 - 0.1 > 0 && (time >= 0 && time <= 100)) {
			this.setPositionX(this.getPositionX() + ((Math.random() * 5 - 1.5) * Math.cos(this.getVelocityX()) + 2));
			time++;
		} else {
			this.setPositionX(this.getPositionX() - ((Math.random() * 3 - 1.5) * Math.cos(this.getVelocityX()) + 0.5));
			time++;
		}
		if (time >= 100)
			time = -100;

		if (this.getPositionY() > 0)
			this.setPositionY(this.getPositionY() + (Math.random() * 5 - 1.5) * Math.sin(this.getVelocityY()));
		else
			this.setPositionY(this.getPositionY() + (Math.random() * 5 + 1));
		this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
		
		relocatePositionIfNeed();
	}

}