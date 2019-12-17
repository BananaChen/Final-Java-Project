package destination;

import items.*;
import windows.*;

import java.util.ArrayList;

public class Flower extends Destination {

	public static boolean isShooted = false;
	public int temp = 0;
	
	public Flower(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 300, imagePath);
	}

	
	public void effect(ArrayList<Items> items, Scene currentScene) {
		Person person = (Person)items.get(0);
		if (person.getPositionX() + person.labelWidth > this.positionX
				&& person.getPositionX() < (this.positionX + this.imageWidth)
				&& (person.getPositionY() + person.labelHeight) > this.positionY
				&& person.getPositionY() < this.positionY + this.imageHeight) {
			person.setVelocityY(-6);
			this.lb.setVisible(false);
			isShooted = true;
			lbSuccess.setVisible(true);

			currentScene.isPassed = true;
			temp++;
			if(temp>=100){
				currentScene.timer.stop();
			}
			
			setNextStageStatus(currentScene);
			
		} else if (person.getPositionY() > 800 && isShooted == false) {
			lbFail.setVisible(true);
			person.setVelocityY(0);
			person.setAccelerationY(0);
			
			currentScene.timer.stop();
		}
	}
}
