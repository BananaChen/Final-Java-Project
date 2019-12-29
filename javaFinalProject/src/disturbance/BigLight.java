package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class BigLight extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/Sar53Xp.gif";

	public BigLight(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 100, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			if (hasContactWithPerson(person)) {
				person.getLabel().setSize(100,100);
			}
		});
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if (this.getPositionX() - person.getPositionX() < person.imageWidth
				&& (this.getPositionX() + this.imageWidth) > person.getPositionX())
			return true;
		return false;
	}
}
