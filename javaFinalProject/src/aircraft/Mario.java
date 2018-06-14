package aircraft;


import java.awt.*;
import javax.swing.*;

import items.*;

import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Mario extends Aircraft {

	private String imagePath = "https://i.imgur.com/2wX6akd.gif";


	public Mario(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(1, 1, 200, 100, imagePath);
	}

	@Override
	public void move() {
		// this.valocityX += this.accelerationX;
		this.velocityX += this.accelerationX;
		this.positionX += this.velocityX;
		this.positionY += this.velocityY;
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
		if(this.positionX > 220) {
			this.positionX = -500;
		}
	}

}
