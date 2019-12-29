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
	
	@Override
	public void move() {
		this.setPositionX(this.getPositionX() + ((moveLeft) ? -2 : 2));
		if (this.getPositionX() <= 400 || this.getPositionX() + imageWidth >= 1200) {
			moveLeft = !moveLeft;
			moveRight = !moveRight;
		}
		this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			checkLandingStatus(person, currentScene);
		});
	}
	
	@Override
	public void successHandler(Person person, Scene scene) {
		((Thug)person).lbSunGlasses.setVisible(true);
		scene.successLabel.setLabelVisibility(true);
		scene.isPassed = true;
		scene.timer.stop();
	}

	@Override
	public boolean successfulLanding(Person person) {
		if (person.isDropped && person.getPositionX() >= this.getPositionX()+50
				&& person.getPositionX() + person.imageWidth <= this.getPositionX()+this.imageWidth-50
				&& person.getPositionY() + person.imageHeight >= this.getPositionY()+this.imageHeight*0.3
				&& person.getPositionY() + person.imageHeight <= this.getPositionY()+this.imageHeight*0.9)
			return true;
		return false;
	}

	@Override
	public boolean failedLanding(Person person) {
		if (person.isDropped && ((this.getPositionY()+this.imageHeight) - person.getPositionY() < 0
					|| person.blood == 0))
			return true;
		return false;
	}

}