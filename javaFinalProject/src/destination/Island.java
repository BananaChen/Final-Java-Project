package destination;

import items.*;
import windows.*;

import java.util.ArrayList;

public class Island extends Destination {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/T8Jrc9m.png";

	public Island(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 350, 369, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);
			// if successfully landing
			if (successfulLanding(person)) {
				currentScene.successHandler();
				setNextStageStatus(currentScene);

			}
			// if not
			else if (failedLanding(person)) {
				personActionAfterward(person);
				currentScene.failureHandler();
			}
		}
	}

	@Override
	public boolean successfulLanding(Person person) {
		if (person.isDropped && person.getPositionX() + person.imageWidth >= this.positionX+50
					&& person.getPositionX() + person.imageWidth <= this.positionX+this.imageWidth
					&& person.getPositionY() + person.imageHeight >= this.positionY+this.imageHeight*0.85
					&& person.getPositionY() + person.imageHeight <= this.positionY+this.imageHeight)
			return true;
		return false;
	}

	@Override
	public boolean failedLanding(Person person) {
		if (person.isDropped && (this.getPositionY()+this.imageHeight) - person.positionY < 0)
			return true;
		return false;
	}
}