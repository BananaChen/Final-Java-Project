package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class DownPipe extends Disturbance {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/SlaRZLw.png";

	public DownPipe(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 400, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (Items item : items) {
			if (item instanceof Person) {
				Person person = (Person) item;
				if (person.getPositionX() + person.labelWidth > this.positionX
						&& person.getPositionY() + person.labelHeight > this.positionY
						&& person.getPositionX() < this.positionX + this.imageWidth) {
					person.setVelocityX(0);
				}
			}
		}
	}
}
