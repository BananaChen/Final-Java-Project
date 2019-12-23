package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class UpPipe extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/awVA3HM.png";

	public UpPipe(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 340, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;
				if (hasContactWithPerson(person)) {
					person.setVelocityX(0);
				}
			}
		}
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (person.getPositionX() + person.labelWidth > this.positionX
				&& person.getPositionY() < this.positionY + this.imageHeight
				&& person.getPositionX() < this.positionX + this.imageWidth)
			return true;
		return false;
	}
}
