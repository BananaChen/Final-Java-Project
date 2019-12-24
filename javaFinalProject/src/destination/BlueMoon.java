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
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			// if successfully landing
			if (successfulLanding(person)) {
				personActionAfterward(person);
				successHandler(currentScene);
				setNextStageStatus(currentScene);
			}
			// if not
			else if (failedLanding(person)) {
				personActionAfterward(person);
				failureHandler(currentScene);
			}
		});
	}
	
	public boolean successfulLanding(Person person) {
		if (person.isDropped && person.getPositionX() + person.imageWidth >= 1250
				&& person.getPositionX() + person.imageWidth <= 1650
				&& person.getPositionY() + person.imageHeight >= 900
				&& person.getPositionY() + person.imageHeight <= 963)
			return true;
		return false;
	}
	
	public boolean failedLanding(Person person) {
		if (person.isDropped && person.getPositionY() + person.imageHeight < 0
				|| person.getPositionY() > Scene.bgHeight || person.getPositionX() > Scene.bgWidth
				|| person.getPositionX() + person.imageWidth < 0)
			return true;
		return false;
	}
}