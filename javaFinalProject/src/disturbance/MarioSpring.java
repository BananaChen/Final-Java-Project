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
		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;
				if (this.positionX - person.getPositionX() < person.labelWidth
						&& (this.positionX + this.imageWidth) > person.getPositionX()
						&& this.positionY - person.getPositionY() < person.imageHeight
						&& (this.positionY + this.imageHeight) > person.getPositionY()) {
					person.setVelocityX(8);
					person.setVelocityY(-8);
				}
			}
		}
	}
}
