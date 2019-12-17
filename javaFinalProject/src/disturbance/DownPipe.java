package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class DownPipe extends Disturbance {

	private String imagePath = "https://i.imgur.com/SlaRZLw.png";

	public DownPipe(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 400, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);
			if (person.getPositionX() + person.labelWidth > this.positionX
					&& person.getPositionY() + person.labelHeight > this.positionY
					&& person.getPositionX() < this.positionX + this.imageWidth) {
				person.setVelocityX(0);
			}
		}
	}
}
