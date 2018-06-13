package destination;

import items.*;
import windows.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

public class Honeycomb extends Destination implements ActionListener {

	private static final long serialVersionUID = -4756067190093780646L;

	Timer timer;
	public int screenWidth = 1920;
	public int screenHeight = 1000;

	boolean moveRight = false;
	boolean moveLeft = true;

	public Honeycomb(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);

		imageWidth = 400;
		imageHeight = 300;

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
			if (person.isDropped && person.getPositionX() + person.imageWidth >= this.positionX+45
					&& person.getPositionX() + person.imageWidth <= this.positionX+this.imageWidth-45
					&& person.getPositionY() + person.imageHeight >= this.positionY+this.imageHeight*0.02
					&& person.getPositionY() + person.imageHeight <= this.positionY+this.imageHeight*0.2) {
				lbSuccess.setVisible(true);
				// Scene2.person.lb.setVisible(false);
				this.timer.stop();
				person.gx = person.positionX;
				person.lbThugLife.setLocation((int) person.positionX, screenHeight);
				person.lbThugLife.setVisible(true);
				person.timer.start();

				curStage.isPassed = true;
				curStage.timer.stop();
				setNextStageStatus(curStage);
			}
			// if not
			else if (person.isDropped && ((this.getPositionY()+this.imageHeight) - person.positionY < 0
					|| person.blood == 0)) {
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
		if (moveLeft && this.positionX <= 400) {
			moveLeft = false;
			moveRight = true;
		}
		if (moveRight && this.positionX + imageWidth >= 1200) {
			moveLeft = true;
			moveRight = false;
		}

		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}
}