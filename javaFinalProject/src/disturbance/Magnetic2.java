package disturbance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import items.*;

public class Magnetic2 extends Disturbance {
	private String imagePath = "https://i.imgur.com/PXJrme7.png";

	private boolean moveRight = false;
	private boolean moveLeft = true;

	public Magnetic2(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);

		setImage(x, y, 200, 200, imagePath);

	}

	public void effect(ArrayList<Person> persons) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			if (person.isDropped && person.getPositionX() + person.imageWidth / 2 >= this.positionX - 70
					&& person.getPositionX() + person.imageWidth / 2 <= this.positionX + this.imageWidth + 70
					&& person.getPositionY() + person.imageHeight / 2 >= 0
					&& person.getPositionY() + person.imageHeight / 2 <= 1000) {

				person.velocityY += 0.01;
				person.velocityX += this.velocityX * 0.01;
			}
		}

		if (moveRight) {
			this.velocityX = 4;
			this.positionX += this.velocityX;
			if (this.positionX >= 800) {
				moveRight = false;
				moveLeft = true;
			}
		}
		if (moveLeft) {
			this.velocityX = -4;
			this.positionX += this.velocityX;
			if (this.positionX <= 100) {
				moveRight = true;
				moveLeft = false;
			}
		}
		this.lb.setLocation((int) this.positionX, (int) this.positionY);

	}

}
