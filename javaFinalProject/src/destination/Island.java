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

	public void effect(ArrayList<Person> persons, Scene curStage) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (Math.acos(person.getPositionY() + 100 - this.positionY) < 50
					&& (person.getPositionX() - this.positionX < 600 && person.getPositionX() - this.positionX > 0)) {
				lbSuccess.setVisible(true);
				person.lb.setVisible(false);
				
				curStage.isPassed = true;
				curStage.timer.stop();
				setNextStageStatus(curStage);

			}
			// if not
			else if (this.positionY - (person.getPositionY()) < 0) {
				curStage.timer.stop();
				lbFail.setVisible(true);
				person.lb.setVisible(false);
			}
		}
	}
}
