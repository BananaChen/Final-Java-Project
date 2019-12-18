package destination;

import items.*;
import windows.*;

import java.util.ArrayList;

public class Home extends Destination {

	private static final long serialVersionUID = 1L;
	private String imagePath = "https://i.imgur.com/N8Il1QP.png";

	public Home(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 350, 292, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);
			// if successfully landing
			if (person.isDropped && person.getPositionX() + person.imageWidth >= this.positionX
					&& person.getPositionX() + person.imageWidth <= this.positionX+this.imageWidth
					&& person.getPositionY() + person.imageHeight >= this.positionY
					&& person.getPositionY() + person.imageHeight <= this.positionY+this.imageHeight) {
				
				person.lb.setVisible(false);
				
				currentScene.successHandler();
				setNextStageStatus(currentScene);

			}
			// if not
			else if (this.positionY - (person.getPositionY()) < 0) {
				person.lb.setVisible(false);
				currentScene.failureHandler();
			}
		}
	}

}