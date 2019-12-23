package disturbance;

import java.util.ArrayList;

import items.*;
import windows.Scene;

public class Road extends Disturbance {

	private static final long serialVersionUID = 1L;

	public Road(int x, int y, int vx, int vy, int ax, int ay, String imagePath) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 400 , 60, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {
		
	}

	@Override
	public boolean hasContactWithPerson(Person person) {
		return false;
	}
}