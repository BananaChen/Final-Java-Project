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

		this.velocityX += this.accelerationX;
		this.velocityY += this.accelerationY;

		if (Math.random() * 2 - 0.1 > 0 && (time >= 0 && time <= 100)) {
			this.positionX += (Math.random() * 5 - 1.5) * Math.cos(this.velocityX) + 2;
			time++;
		} else {
			this.positionX -= (Math.random() * 3 - 1.5) * Math.cos(this.velocityX) + 0.5;
			time++;
		}
		if (time >= 100)
			time = -100;

		if (this.positionY > 0)
			this.positionY += (Math.random() * 5 - 1.5) * Math.sin(this.velocityY);
		else
			this.positionY += Math.random() * 5 + 1;
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}

}