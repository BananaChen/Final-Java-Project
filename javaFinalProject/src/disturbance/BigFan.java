package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class BigFan extends Disturbance {
	private String imagePath = "https://i.imgur.com/E5Lc8S2.gif";

	public BigFan(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 226, 300, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);
			if (person.getPositionY() + person.imageHeight > this.getPositionY() + this.imageHeight / 5
					&& person.getPositionY() + person.imageHeight < (this.getPositionY() + this.imageHeight)) {
				person.setVelocityX(person.getVelocityX() + 0.05);
			}
		}

	}

}