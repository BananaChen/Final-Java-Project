package disturbance;

import java.util.ArrayList;

import items.*;

public class Road extends Disturbance {

	private String imagePath = "https://i.imgur.com/wz1WDDg.jpg";

	public Road(int x, int y, int vx, int vy, int ax, int ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 400 , 60, imagePath);
	}

	public void effect(ArrayList<Person> persons) {
		
	}
}