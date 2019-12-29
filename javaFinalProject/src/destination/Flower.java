package destination;

import items.*;
import windows.*;

import java.util.ArrayList;

public class Flower extends Destination {

	private static final long serialVersionUID = 1L;
	public static boolean isShooted = false;
	public int temp = 0;
	
	public Flower(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 300, imagePath);
	}

	
	public void effect(ArrayList<Items> items, Scene currentScene) {
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			checkLandingStatus(person, currentScene);
		});
	}
	
	@Override
	public void successHandler(Person person, Scene scene) {
		person.setVelocityY(-6);
		this.setLabelVisibility(false);
		isShooted = true;
		
		scene.successLabel.setLabelVisibility(true);
		scene.isPassed = true;
		scene.timer.stop();
	}
	
	@Override
	public void failureHandler(Person person, Scene scene) {
		person.setVelocityY(0);
		person.setAccelerationY(0);
		scene.failureLabel.setLabelVisibility(true);
		scene.timer.stop();
	}

	@Override
	public boolean successfulLanding(Person person) {
		if (person.getPositionX() + person.labelWidth > this.getPositionX()
				&& person.getPositionX() < (this.getPositionX() + this.imageWidth)
				&& (person.getPositionY() + person.labelHeight) > this.getPositionY()
				&& person.getPositionY() < this.getPositionY() + this.imageHeight)
			return true;
		return false;
	}


	@Override
	public boolean failedLanding(Person person) {
		if (person.getPositionY() > 800 && isShooted == false)
			return true;
		return false;
	}
}
