package destination;

import items.*;
import person.*;
import windows.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Honeycomb extends Destination{

	private static final long serialVersionUID = -4756067190093780646L;

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
			if (person.isDropped && person.getPositionX() >= this.positionX+50
				&& person.getPositionX() + person.imageWidth <= this.positionX+this.imageWidth-50
				&& person.getPositionY() + person.imageHeight >= this.positionY+this.imageHeight*0.3
				&& person.getPositionY() + person.imageHeight <= this.positionY+this.imageHeight*0.9) {
				lbSuccess.setVisible(true);
				// Scene2.person.lb.setVisible(false);
				((Thug)person).gx = person.positionX;
				((Thug)person).lbSunGlasses.setLocation((int) person.positionX, screenHeight);
				((Thug)person).lbSunGlasses.setVisible(true);
				((Thug)person).timer.start();

				currentScene.isPassed = true;
				currentScene.timer.stop();
				setNextStageStatus(currentScene);
			}
			// if not
			else if (person.isDropped && ((this.getPositionY()+this.imageHeight) - person.positionY < 0
					|| person.blood == 0)) {
				lbFail.setVisible(true);
				person.lb.setVisible(false);
				person.blood = 0;
				
				currentScene.timer.stop();
			}
		}
	}

}