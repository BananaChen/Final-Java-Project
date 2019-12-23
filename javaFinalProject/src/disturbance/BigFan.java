package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class BigFan extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/E5Lc8S2.gif";

	public BigFan(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 226, 300, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;
				if (hasContactWithPerson(person)) {
					person.setVelocityX(person.getVelocityX() + 0.05);
				}
			}
		}

	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (person.getPositionY() + person.imageHeight > this.getPositionY() + this.imageHeight / 5
						&& person.getPositionY() + person.imageHeight < (this.getPositionY() + this.imageHeight))
			return true;
		return false;
	}

}