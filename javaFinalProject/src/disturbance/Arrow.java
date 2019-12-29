package disturbance;

import items.*;
import windows.Scene;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class Arrow extends Disturbance implements ActionListener {

	private static final long serialVersionUID = -2175622363441527169L;
	boolean isStop = false;
	int waitTime = 0;
	Timer timer;
	public int screenWidth = 1920;
	public int screenHeight = 1000;
	
	public Arrow(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 100;
		imageHeight = 100;
		timer = new Timer(9, this);
		setImage(x, y, imageWidth, imageHeight, imagePath);

		timer.start();
	}

	public void move() {
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		items.stream().filter(item -> item instanceof Person).forEach((item) -> {
			Person person = (Person) item;
			// if getting shoot
			if (hasContactWithPerson(person)) {
				person.setPositionX(person.getPositionX() + 10);
				// relocated
				relocateDisturbance();
				isStop = true;
				// set a random time to wait to restart
				waitTime = (int) (Math.random() * 100 + 1);
				
				// decrease blood
				if (person.isDropped) {
					person.blood--;
				}
			}
	
			// if out of bounds, relocated
			if (this.getPositionY() + 100 < 0 || this.getPositionX() > screenWidth) {
				relocateDisturbance();
				isStop = true;
				// set a random time to wait to restart
				waitTime = (int) (Math.random() * 100 + 1);
			}
		});
	}
	
	public void relocateDisturbance() {
		this.setPositionX(Math.random() * screenWidth - screenWidth);
		this.setPositionY(Math.random() * 200 + screenHeight);
		this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// restart or move
		if (isStop && waitTime > 0) {
			waitTime--;
			this.setPositionX(0);
			this.setPositionY(screenHeight);
			if (waitTime <= 0) { // restart
				isStop = false;
				this.setPositionX(Math.random() * screenWidth - screenWidth);
				this.setPositionY(Math.random() * 200 + screenHeight);
			}
		} else {
			this.setPositionX(this.getPositionX() + 15);
			this.setPositionY(this.getPositionY() - 15);
		}
		this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		if ((this.getPositionX() + 100 > person.getPositionX()
				&& this.getPositionX() + 100 < person.getPositionX() + 100)
				&& (this.getPositionY() > person.getPositionY()
						&& this.getPositionY() < person.getPositionY() + 100))
			return true;
		return false;
	}

}