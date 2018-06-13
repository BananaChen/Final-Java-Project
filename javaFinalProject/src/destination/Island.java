package destination;

import items.*;
import windows.*;

import java.util.ArrayList;

public class Island extends Destination {

	private String imagePath = "https://i.imgur.com/T8Jrc9m.png";

	public Island(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 350, 369, imagePath);
	}

	public void effect(ArrayList<Person> persons, Scene curStage) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (person.isDropped && person.getPositionX() + person.imageWidth >= this.positionX+50
					&& person.getPositionX() + person.imageWidth <= this.positionX+this.imageWidth
					&& person.getPositionY() + person.imageHeight >= this.positionY+this.imageHeight*0.85
					&& person.getPositionY() + person.imageHeight <= this.positionY+this.imageHeight) {
				lbSuccess.setVisible(true);
				//person.lb.setVisible(false);
				curStage.isPassed = true;
				curStage.timer.stop();
				setNextStageStatus(curStage);

			}
			// if not
			else if (person.isDropped && (this.getPositionY()+this.imageHeight) - person.positionY < 0) {
				lbFail.setVisible(true);
				person.lb.setVisible(false);
				
				curStage.timer.stop();
			}
		}
	}
}