package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class Magnetic1 extends Disturbance {
	private String imagePath = "https://i.imgur.com/PEHNulX.png";

	public Magnetic1(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);
			if (person.isDropped && person.getPositionX() + person.imageWidth / 2 >= 0
					&& person.getPositionX() + person.imageWidth / 2 <= 1000
					&& person.getPositionY() + person.imageHeight / 2 >= 300
					&& person.getPositionY() + person.imageHeight / 2 <= 500) {

				person.velocityX += -0.01;
			}
		}

	}

}
