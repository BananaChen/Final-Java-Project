package items;

import java.util.ArrayList;

import windows.Scene;

public abstract class Aircraft extends Items {
	private static final long serialVersionUID = 1L;

	public Aircraft(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		
	}
	
	public void relocatePositionIfNeed() {
		if (getPositionX() > Scene.bgWidth) {
			setPositionX(-imageWidth);
		}
	}
}