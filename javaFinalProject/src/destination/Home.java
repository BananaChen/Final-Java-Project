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
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			checkLandingStatus(person, currentScene);
		});
	}

	@Override
	public boolean successfulLanding(Person person) {
		if (person.isDropped && person.getPositionX() + person.imageWidth >= this.getPositionX()
					&& person.getPositionX() + person.imageWidth <= this.getPositionX()+this.imageWidth
					&& person.getPositionY() + person.imageHeight >= this.getPositionY()
					&& person.getPositionY() + person.imageHeight <= this.getPositionY()+this.imageHeight)
			return true;
		return false;
	}

	@Override
	public boolean failedLanding(Person person) {
		if (this.getPositionY() - (person.getPositionY()) < 0)
			return true;
		return false;
	}

}