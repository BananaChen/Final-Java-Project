package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class SmallLight extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/sHxjvrm.gif";

	public SmallLight(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 100, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;
				if (hasContactWithPerson(person)) {
					//person.setImage(person.getPositionX(), person.getPositionY(), 30, 30, "https://i.imgur.com/2CToQ7a.png");
					person.getLabel().setSize(30,30);
				}
			}
		}
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (this.positionX - person.getPositionX() < person.imageWidth
				&& (this.positionX + this.imageWidth) > person.getPositionX())
			return true;
		return false;
	}
}
