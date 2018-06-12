package destination;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

import items.Aircraft;
import items.Destination;
import items.Person;
import windows.Scene;
import windows.Stage2;
import windows.WindowController;

public class Honeycomb extends Destination implements ActionListener{
	
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
		
		//start timer
		timer.start();
	}
	
	public void collideEvent() {
	}
	
	public void effect(ArrayList<Person> persons) {
		//if successfully landing
		if (Math.acos(persons.get(0).getPositionY()+100 - this.positionY) < 5 && (persons.get(0).getPositionX()+50 < this.positionX+imageWidth && persons.get(0).getPositionX()+50 > this.positionX)) {
			lbSuccess.setVisible(true);
			//Scene2.persons.get(0).lb.setVisible(false);
			Stage2.timer.stop();
			this.timer.stop();
			persons.get(0).gx = persons.get(0).positionX;
			persons.get(0).lbThugLife.setLocation((int)persons.get(0).positionX, screenHeight);
			persons.get(0).lbThugLife.setVisible(true);
			persons.get(0).timer.start();
			Scene.isPassed = true;
			if (Scene.isPassed) {
				for (int j = 0; j < WindowController.NumOfStage; ++j) {
					if (WindowController.stageStatus[j] == true) {
						WindowController.stageStatus[j] = false;
						WindowController.stageStatus[j + 1] = true;
						break;
					}

				}
			}
		}
		//if not
		else if (this.positionY - (persons.get(0).getPositionY()) < 0 || persons.get(0).getPositionX() > screenWidth || persons.get(0).blood==0) {
			lbFail.setVisible(true);
			persons.get(0).lb.setVisible(false);
			persons.get(0).blood = 0;
			Stage2.timer.stop();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//move left
		if (moveLeft)
			this.positionX -= 2;
		//move right
		if (moveRight)
			this.positionX += 2;
		
		//boundary
		if (moveLeft && this.positionX <= 300) {
			moveLeft = false;
			moveRight = true;
		}
		if (moveRight && this.positionX+imageWidth >= 900) {
			moveLeft = true;
			moveRight = false;
		}
			
		this.lb.setLocation((int)this.positionX,(int)this.positionY);
	}
}
