package destination;

import items.*;
import windows.*;

import java.util.ArrayList;

public class Home extends Destination {

	private String imagePath = "https://i.imgur.com/N8Il1QP.png";

	public Home(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 350, 292, imagePath);
	}

	public void effect(ArrayList<Person> persons, Scene curStage) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (person.isDropped && person.getPositionX() + person.imageWidth >= this.positionX
					&& person.getPositionX() + person.imageWidth <= this.positionX+this.imageWidth
					&& person.getPositionY() + person.imageHeight >= this.positionY
					&& person.getPositionY() + person.imageHeight <= this.positionY+this.imageHeight) {
				lbSuccess.setVisible(true);
				person.lb.setVisible(false);
				
				curStage.isPassed = true;
				curStage.timer.stop();
				setNextStageStatus(curStage);

			}
			// if not
			else if (this.positionY - (person.getPositionY()) < 0) {
				lbFail.setVisible(true);
				person.lb.setVisible(false);
				curStage.timer.stop();
			}
		}
	}

}