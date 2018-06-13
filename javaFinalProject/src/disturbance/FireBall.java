package disturbance;

import items.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class FireBall extends Disturbance implements ActionListener {

	private static final long serialVersionUID = -2175622363441527169L;
	boolean isStop = false;
	int waitTime = 0;
	Timer timer;
	double resetX;
	double resetY;

	public FireBall(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 100;
		imageHeight = 100;
		timer = new Timer(9, this);
		setImage(x, y, imageWidth, imageHeight, imagePath);
		timer.start();
	}

	public void move() {
	}

	public void effect(ArrayList<Person> persons, ArrayList<Aircraft> aircrafts) {
		resetX = aircrafts.get(0).getPositionX() - 20;
		resetY = aircrafts.get(0).getPositionY() + 50;

		// if getting shoot
		if ((this.positionX + 100 > persons.get(0).getPositionX()
				&& this.positionX + 100 < persons.get(0).getPositionX() + 100)
				&& (this.positionY > persons.get(0).getPositionY()
						&& this.positionY < persons.get(0).getPositionY() + 100)) {
			persons.get(0).setPositionX(persons.get(0).getPositionX() - 5);
			// relocated
			this.positionX = resetX;
			this.positionY = resetY;
			this.lb.setLocation((int) this.positionX, (int) this.positionY);
			isStop = true;
			// set a random time to wait to restart
			waitTime = (int) (Math.random() * 100 + 1);
			if (persons.get(0).isDropped)
				persons.get(0).blood--;
		}

		// if out of bounds, relocated
		if (this.positionY + 100 > 1000 || this.positionX < -100) {
			this.positionX = resetX;
			this.positionY = resetY;
			this.lb.setLocation((int) this.positionX, (int) this.positionY);

			isStop = true;
			// set a random time to wait to restart
			waitTime = (int) (Math.random() * 100 + 1);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// restart or move
		if (isStop && waitTime > 0) {
			waitTime--;
			this.positionX = 100;
			this.positionY = -100;
		} else if (isStop == true && waitTime == 0) {
			this.positionX = resetX;
			this.positionY = resetY;
			isStop = false;
		} else {
			this.positionX -= 5;
			this.positionY += 5;
		}
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}

	@Override
	public void effect(ArrayList<Person> persons) {
		// TODO Auto-generated method stub

	}

}