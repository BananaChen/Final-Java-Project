package aircraft;

import items.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class AirPlane extends Aircraft {

	private String imagePath = "https://i.imgur.com/JgxwTCy.png";

	public AirPlane(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(1, 1, 200, 100, imagePath);
	}

	@Override
	public void move() {
		// this.valocityX += this.accelerationX;
		this.velocityX += this.accelerationX;
		this.positionX += this.velocityX;
		this.lb.setLocation((int) this.positionX, (int) this.positionY);
		/*
		 * vx += ax; vy += ay; x += vx; y += vy;
		 */
	}

	@Override
	public void collideEvent() {

	}

	@Override
	public void effect() {

	}
}
