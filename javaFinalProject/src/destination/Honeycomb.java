package destination;

import items.*;
import person.*;
import windows.*;

import java.util.ArrayList;

public class Honeycomb extends Destination{

	private static final long serialVersionUID = 1L;
	public int screenWidth = 1920;
	public int screenHeight = 1000;

	boolean moveRight = false;
	boolean moveLeft = true;

	public Honeycomb(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);

		imageWidth = 400;
		imageHeight = 300;

		setImage(x, y, imageWidth, imageHeight, imagePath);

	}

	public void collideEvent() {
	}
	
	public void effect(ArrayList<Items> items, Scene currentScene) {
		// move left
		if (moveLeft)
			this.positionX -= 2;
		// move right
		if (moveRight)
			this.positionX += 2;
			// boundary
		if (moveLeft && this.positionX <= 400) {
			moveLeft = false;
			moveRight = true;
		}
		if (moveRight && this.positionX + imageWidth >= 1200) {
			moveLeft = true;
			moveRight = false;
		}
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
			
		for (int i = 0; i < items.size(); ++i) {
			Person person = (Person)items.get(i);
			// if successfully landing
			if (successfulLanding(person)) {
				((Thug)person).lbSunGlasses.setVisible(true);
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
		if (person.isDropped && person.getPositionX() >= this.positionX+50
				&& person.getPositionX() + person.imageWidth <= this.positionX+this.imageWidth-50
				&& person.getPositionY() + person.imageHeight >= this.positionY+this.imageHeight*0.3
				&& person.getPositionY() + person.imageHeight <= this.positionY+this.imageHeight*0.9)
			return true;
		return false;
	}

	@Override
	public boolean failedLanding(Person person) {
		if (person.isDropped && ((this.getPositionY()+this.imageHeight) - person.positionY < 0
					|| person.blood == 0))
			return true;
		return false;
	}

}