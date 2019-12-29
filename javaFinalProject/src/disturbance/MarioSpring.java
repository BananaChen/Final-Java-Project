package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class MarioSpring extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/LfhHpCK.png";

	public MarioSpring(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 100, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			if (hasContactWithPerson(person)) {
				person.setVelocityX(8);
				person.setVelocityY(-8);
			}
		});
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (this.getPositionX() - person.getPositionX() < person.labelWidth
				&& (this.getPositionX() + this.imageWidth) > person.getPositionX()
				&& this.getPositionY() - person.getPositionY() < person.imageHeight
				&& (this.getPositionY() + this.imageHeight) > person.getPositionY())
			return true;
		return false;
	}
}
