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

	public void effect(ArrayList<Person> persons) {
		// if successfully landing
		if (Math.acos(persons.get(0).getPositionY() + 100 - this.positionY) < 5
				&& (persons.get(0).getPositionX() + 50 < this.positionX + imageWidth
						&& persons.get(0).getPositionX() + 50 > this.positionX)) {
			lbSuccess.setVisible(true);
			// Scene2.persons.get(0).lb.setVisible(false);
			this.timer.stop();
			persons.get(0).gx = persons.get(0).positionX;
			persons.get(0).lbThugLife.setLocation((int) persons.get(0).positionX, screenHeight);
			persons.get(0).lbThugLife.setVisible(true);
			persons.get(0).timer.start();
			Scene.isPassed = true;

			Stage2.timer.stop();
			setNextStageStatus();
		}
		// if not
		else if (this.positionY - (persons.get(0).getPositionY()) < 0 || persons.get(0).getPositionX() > screenWidth
				|| persons.get(0).blood == 0) {
			lbFail.setVisible(true);
			persons.get(0).lb.setVisible(false);
			persons.get(0).blood = 0;
			Stage2.timer.stop();
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
