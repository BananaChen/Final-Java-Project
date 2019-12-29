package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class Magnetic2 extends Disturbance {

	private static final long serialVersionUID = 1L;

	private String imagePath = "https://i.imgur.com/PXJrme7.png";

	private boolean moveRight = false;
	private boolean moveLeft = true;

	public Magnetic2(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);

		setImage(x, y, 200, 200, imagePath);

	}
	
	@Override
	public void move() {
		this.setPositionX(this.getPositionX() + (moveRight ? 4 : -4));
		if (this.getPositionX() >= 800 || this.getPositionX() <= 100) {
			moveRight = !moveRight;
			moveLeft = !moveLeft;
		}
		this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			if (hasContactWithPerson(person)) {
				person.setVelocityY(person.getVelocityY() + 0.01);
				person.setVelocityX(this.getVelocityX() * 0.01);
			}
		});
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (person.isDropped && person.getPositionX() + person.imageWidth / 2 >= this.getPositionX() - 70
				&& person.getPositionX() + person.imageWidth / 2 <= this.getPositionX() + this.imageWidth + 70
				&& person.getPositionY() + person.imageHeight / 2 >= 0
				&& person.getPositionY() + person.imageHeight / 2 <= 1000)
			return true;
		return false;
	}

}
