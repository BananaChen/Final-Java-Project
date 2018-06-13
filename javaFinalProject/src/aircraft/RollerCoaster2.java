package aircraft;

import items.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RollerCoaster2 extends Aircraft {

	private String imagePath = "https://i.imgur.com/2CToQ7a.png";
	double degrees = 0;
	
	public RollerCoaster2(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(1, 1, 100, 100, imagePath);
	}

	@Override
	public void move() {
		// this.valocityX += this.accelerationX;
		
		degrees += 3;
        double radians = Math.toRadians(degrees);
        
		this.positionX += (5*Math.sin(radians) + this.velocityX);
		this.positionY -= 5*Math.cos(radians);
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
