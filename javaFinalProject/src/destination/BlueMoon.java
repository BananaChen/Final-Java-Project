package destination;

import java.util.ArrayList;

import items.Destination;
import items.Items;
import items.Person;
import windows.Scene;

public class BlueMoon extends Destination {
	private static final long serialVersionUID = 1L;

	public BlueMoon(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);

		imageWidth = 400;
		imageHeight = 133;

		setImage(x, y, imageWidth, imageHeight, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);
			// if successfully landing
			if (person.isDropped && person.getPositionX() + person.imageWidth >= 1250
					&& person.getPositionX() + person.imageWidth <= 1650
					&& person.getPositionY() + person.imageHeight >= 900
					&& person.getPositionY() + person.imageHeight <= 963) {
				
				person.setAccelerationX(0);
				person.setAccelerationY(0);
				person.setVelocityX(0);
				person.setVelocityY(0);
				
				currentScene.successHandler();
				setNextStageStatus(currentScene);
			}
			// if not
			else if (person.isDropped && person.getPositionY() + person.imageHeight < 0
					|| person.getPositionY() > Scene.bgHeight || person.getPositionX() > Scene.bgWidth
					|| person.getPositionX() + person.imageWidth < 0) {
				
				person.setVisible(false);
				person.setAccelerationX(0);
				person.setAccelerationY(0);
				person.setVelocityX(0);
				person.setVelocityY(0);
				
				currentScene.failureHandler();
			}
		}
	}
}