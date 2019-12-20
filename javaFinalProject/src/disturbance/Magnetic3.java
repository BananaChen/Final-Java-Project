package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class Magnetic3 extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/EOrrvWn.png";

	public Magnetic3(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 250, 400, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;
				if (person.isDropped && person.getPositionX() + person.imageWidth / 2 >= 750
						&& person.getPositionX() + person.imageWidth / 2 <= 1920
						&& person.getPositionY() + person.imageHeight / 2 >= 400
						&& person.getPositionY() + person.imageHeight / 2 <= 1000) {

					person.velocityX += 0.07;
					person.velocityY += 0.007;
				}
			}
		}

	}

}
