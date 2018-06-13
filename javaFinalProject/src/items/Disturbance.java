package items;

import java.util.ArrayList;

public abstract class Disturbance extends Items {

	public Disturbance(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}

	public void effect(ArrayList<Person> persons, ArrayList<Aircraft> aircrafts) {
		
	}
	public abstract void effect(ArrayList<Person> persons);
	
}