package disturbance;

import java.util.ArrayList;
import items.*;

public class Planet1 extends Disturbance {
	private String imagePath = "https://i.imgur.com/kLmxtW8.png";

	public Planet1(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 400, 241, imagePath);
	}

	public void effect(ArrayList<Person> persons) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			if (person.isDropped && person.getPositionX() + person.imageWidth / 2 >= 0
					&& person.getPositionX() + person.imageWidth / 2 <= this.positionX + this.imageWidth / 2
					&& person.getPositionY() + person.imageHeight / 2 >= 0
					&& person.getPositionY() + person.imageHeight / 2 < 300) {

				person.velocityX += 0.04;
				person.velocityY += 0.005;
			}
			if (person.isDropped
					&& person.getPositionX() + person.imageWidth / 2 >= this.positionX + this.imageWidth / 2
					&& person.getPositionX() + person.imageWidth / 2 <= 1920
					&& person.getPositionY() + person.imageHeight / 2 >= 0
					&& person.getPositionY() + person.imageHeight / 2 < 500) {

				person.velocityX += -0.05;
				person.velocityY += 0.005;
			}
		}

	}

}
