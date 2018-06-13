package destination;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import items.Destination;
import items.Person;
import windows.Scene;

public class BlueMoon extends Destination {

	public BlueMoon(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);

		imageWidth = 400;
		imageHeight = 133;

		setImage(x, y, imageWidth, imageHeight, imagePath);
	}

	public void effect(ArrayList<Person> persons, Scene curStage) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (person.isDropped && person.getPositionX() + person.imageWidth >= 1250
					&& person.getPositionX() + person.imageWidth <= 1650
					&& person.getPositionY() + person.imageHeight >= 900
					&& person.getPositionY() + person.imageHeight <= 963) {
				lbSuccess.setVisible(true);
				person.setAccelerationX(0);
				person.setAccelerationY(0);
				person.setVelocityX(0);
				person.setVelocityY(0);
				
				curStage.isPassed = true;
				curStage.timer.stop();
				setNextStageStatus(curStage);
			}
			// if not
			else if (person.isDropped && person.getPositionY() + person.imageHeight < 0
					|| person.getPositionY() > Scene.bgHeight || person.getPositionX() > Scene.bgWidth
					|| person.getPositionX() + person.imageWidth < 0) {
				lbFail.setVisible(true);
				person.setVisible(false);
				person.setAccelerationX(0);
				person.setAccelerationY(0);
				person.setVelocityX(0);
				person.setVelocityY(0);
				
				curStage.timer.stop();
			}
		}
	}
}