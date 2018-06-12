package destination;

import items.*;
import windows.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Honeycomb extends Destination implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4756067190093780646L;

	Timer timer;
	int screenWidth = 1200;
	int screenHeight = 900;

	boolean moveRight = false;
	boolean moveLeft = true;

	public Honeycomb(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);

		imageWidth = 250;
		imageHeight = 200;

		timer = new Timer(10, this);

		setImage(x, y, imageWidth, imageHeight, imagePath);

		// start timer
		timer.start();
	}

	public void collideEvent() {
	}

	public void effect(ArrayList<Person> persons, Scene curStage) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
			// if successfully landing
			if (Math.acos(person.getPositionY() + 100 - this.positionY) < 5
					&& (person.getPositionX() + 50 < this.positionX + imageWidth
							&& person.getPositionX() + 50 > this.positionX)) {
				lbSuccess.setVisible(true);
				// Scene2.person.lb.setVisible(false);
				this.timer.stop();
				person.gx = person.positionX;
				person.lbThugLife.setLocation((int) person.positionX, screenHeight);
				person.lbThugLife.setVisible(true);
				person.timer.start();
				Scene.isPassed = true;

				curStage.timer.stop();
				setNextStageStatus();
			}
			// if not
			else if (this.positionY - (person.getPositionY()) < 0 || person.getPositionX() > screenWidth
					|| person.blood == 0) {
				lbFail.setVisible(true);
				person.lb.setVisible(false);
				person.blood = 0;
				curStage.timer.stop();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// move left
		if (moveLeft)
			this.positionX -= 2;
		// move right
		if (moveRight)
			this.positionX += 2;

		// boundary
		if (moveLeft && this.positionX <= 300) {
			moveLeft = false;
			moveRight = true;
		}
		if (moveRight && this.positionX + imageWidth >= 900) {
			moveLeft = true;
			moveRight = false;
		}

		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}
}
