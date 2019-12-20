package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class Spring extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/Dlg2zpx.png";

	public Spring(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;
				if (person.getPositionX() + person.imageWidth >= this.positionX
						&& (person.getPositionX() + person.imageWidth) <= this.positionX + this.imageWidth
						&& (person.getPositionY() + person.imageHeight) >= this.positionY
						&& (person.getPositionY() + person.imageHeight) <= this.positionY + this.imageHeight) {
					person.setVelocityX(person.getVelocityX() - 1.5);
				}
			}
		}

	}

}