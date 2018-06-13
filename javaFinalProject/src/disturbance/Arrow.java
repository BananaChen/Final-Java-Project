package disturbance;

import items.*;

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

	public void effect(ArrayList<Person> persons) {
		// if getting shoot
		if ((this.positionX + 100 > persons.get(0).getPositionX()
				&& this.positionX + 100 < persons.get(0).getPositionX() + 100)
				&& (this.positionY > persons.get(0).getPositionY()
						&& this.positionY < persons.get(0).getPositionY() + 100)) {
			persons.get(0).positionX += 10;
			// relocated
			this.positionX = Math.random() * screenWidth - screenWidth;
			this.positionY = Math.random() * 200 + screenHeight;
			this.lb.setLocation((int) this.positionX, (int) this.positionY);
			isStop = true;
			// set a random time to wait to restart
			waitTime = (int) (Math.random() * 100 + 1);
			if (persons.get(0).isDropped) {
				persons.get(0).blood--;
				if(persons.get(0).blood==2)
					persons.get(0).heart3.setVisible(false);
				else if (persons.get(0).blood==1)
					persons.get(0).heart2.setVisible(false);
				else
					persons.get(0).heart1.setVisible(false);
			}
		}

		// if out of bounds, relocated
		if (this.positionY + 100 < 0 || this.positionX > screenWidth) {
			this.positionX = Math.random() * screenWidth - screenWidth;
			this.positionY = Math.random() * 200 + screenHeight;
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
			this.positionX = 0;
			this.positionY = screenHeight;
			if (waitTime <= 0) { // restart
				isStop = false;
				this.positionX = Math.random() * screenWidth - screenWidth;
				this.positionY = Math.random() * 200 + screenHeight;
			}
		} else {
			this.positionX += 15;
			this.positionY -= 15;
		}
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
	}

}