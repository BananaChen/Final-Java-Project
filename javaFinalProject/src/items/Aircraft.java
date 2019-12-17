package items;

import java.util.ArrayList;

import windows.Scene;

public abstract class Aircraft extends Items {

	public Aircraft(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		
	}
}