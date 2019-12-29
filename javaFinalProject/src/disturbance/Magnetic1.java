package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class Magnetic1 extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/PEHNulX.png";

	public Magnetic1(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			if (hasContactWithPerson(person)) {
				person.setVelocityX(person.getVelocityX() + (-0.01));
			}
		});
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (person.isDropped && person.getPositionX() + person.imageWidth / 2 >= 0
				&& person.getPositionX() + person.imageWidth / 2 <= 1000
				&& person.getPositionY() + person.imageHeight / 2 >= 300
				&& person.getPositionY() + person.imageHeight / 2 <= 500)
			return true;
		return false;
	}

}
