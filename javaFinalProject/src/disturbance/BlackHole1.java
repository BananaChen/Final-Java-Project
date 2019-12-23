package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class BlackHole1 extends Disturbance {

	private static final long serialVersionUID = 1L;

	private String imagePath = "https://i.imgur.com/OhyaatF.gif";

	public BlackHole1(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;

				if (hasContactWithPerson(person)) {
					person.lb.setLocation(1650, 300);
					person.setPositionX(1650);
					person.setPositionY(300);
					person.setVelocityX(-5);
				}
			}
		}

	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (person.getPositionX() + person.imageWidth / 2 >= 850
				&& person.getPositionX() + person.imageWidth / 2 <= 1050
				&& person.getPositionY() + person.imageHeight / 2 >= 600
				&& person.getPositionY() + person.imageHeight / 2 <= 800)
			return true;
		return false;
	}

}
