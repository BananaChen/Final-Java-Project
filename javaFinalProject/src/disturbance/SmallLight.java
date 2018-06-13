package disturbance;

import java.util.ArrayList;

import items.*;

public class SmallLight extends Disturbance {

	private String imagePath = "https://i.imgur.com/sHxjvrm.gif";

	public SmallLight(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 100, imagePath);
	}

	public void effect(ArrayList<Person> persons) {
		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			if (this.positionX - person.getPositionX() < person.imageWidth
					&& (this.positionX + this.imageWidth) > person.getPositionX()) {
				//person.setImage(person.getPositionX(), person.getPositionY(), 30, 30, "https://i.imgur.com/2CToQ7a.png");
				person.lb.setSize(30,30);
			}
		}
	}
}
