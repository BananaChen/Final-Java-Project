package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class BlackHole1 extends Disturbance {
	private String imagePath = "https://i.imgur.com/OhyaatF.gif";

	private int stopSend = 0;

	public BlackHole1(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);

			if (person.getPositionX() + person.imageWidth / 2 >= 850
					&& person.getPositionX() + person.imageWidth / 2 <= 1050
					&& person.getPositionY() + person.imageHeight / 2 >= 600
					&& person.getPositionY() + person.imageHeight / 2 <= 800) {
				person.lb.setLocation(1650, 300);
				person.setPositionX(1650);
				person.setPositionY(300);
				person.setVelocityX(-5);
				//person.setVelocityY(0.5);
			}
		}

	}

}
