package person;

import items.*;

public class Alien extends Person{
	
	private String imagePath = "https://i.imgur.com/bg3surr.png";
	
	public Alien(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 137, imagePath);
	}

}