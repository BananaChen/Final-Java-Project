package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class UpPipe extends Disturbance {

	private String imagePath = "https://i.imgur.com/awVA3HM.png";

	public UpPipe(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 340, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person) items.get(i);
			if (person.getPositionX() + person.labelWidth > this.positionX
					&& person.getPositionY() < this.positionY + this.imageHeight
					&& person.getPositionX() < this.positionX + this.imageWidth) {
				person.setVelocityX(0);
			}
		}
	}
}
