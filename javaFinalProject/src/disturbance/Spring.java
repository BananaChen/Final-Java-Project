package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class Spring extends Disturbance {

	private String imagePath = "https://i.imgur.com/Dlg2zpx.png";

	public Spring(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person) items.get(i);
			if (person.getPositionX() + person.imageWidth >= this.positionX
					&& (person.getPositionX() + person.imageWidth) <= this.positionX + this.imageWidth
					&& (person.getPositionY() + person.imageHeight) >= this.positionY
					&& (person.getPositionY() + person.imageHeight) <= this.positionY + this.imageHeight) {
				person.setVelocityX(person.getVelocityX() - 1.5);
			}
		}

	}

}