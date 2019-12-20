package disturbance;

import java.util.ArrayList;
import items.*;
import windows.Scene;

public class BlackHole2 extends Disturbance {

	private static final long serialVersionUID = 1L;

	private String imagePath = "https://i.imgur.com/OhyaatF.gif";

	public BlackHole2(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Items> items, Scene currentScene) {

	}

}
