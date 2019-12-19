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
		Person person = (Person)items.get(0);
		if (successfulLanding(person)) {
			person.setVelocityY(-6);
			this.lb.setVisible(false);
			isShooted = true;
			
			temp++;
			if(temp >= 100){
				currentScene.timer.stop();
			}
			
			currentScene.successHandler();
			setNextStageStatus(currentScene);
			
		} else if (failedLanding(person)) {
			person.setVelocityY(0);
			person.setAccelerationY(0);
			
			currentScene.failureHandler();
		}
	}


	@Override
	public boolean successfulLanding(Person person) {
		if (person.getPositionX() + person.labelWidth > this.positionX
				&& person.getPositionX() < (this.positionX + this.imageWidth)
				&& (person.getPositionY() + person.labelHeight) > this.positionY
				&& person.getPositionY() < this.positionY + this.imageHeight)
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
