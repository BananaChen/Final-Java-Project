package destination;

import items.*;
import windows.*;

import java.util.ArrayList;

public class Island extends Destination {

	private String imagePath = "https://i.imgur.com/rKpizPG.png";

	public Island(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 250, 170, imagePath);
	}

	public void effect(ArrayList<Person> persons) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (Math.acos(person.getPositionY() + 100 - this.positionY) < 50
					&& (person.getPositionX() - this.positionX < 600 && person.getPositionX() - this.positionX > 0)) {
				lbSuccess.setVisible(true);
				person.lb.setVisible(false);
				Scene.isPassed = true;

				Stage1.timer.stop();
				setNextStageStatus();

			}
			// if not
			else if (this.positionY - (person.getPositionY()) < 0) {
				Stage1.timer.stop();
				lbFail.setVisible(true);
				person.lb.setVisible(false);
			}
		}
	}
}
