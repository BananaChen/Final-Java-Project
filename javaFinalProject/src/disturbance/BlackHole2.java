package disturbance;

import java.util.ArrayList;
import items.*;

public class BlackHole2 extends Disturbance {
	private String imagePath = "https://i.imgur.com/OhyaatF.gif";

	private boolean send = false;
	private int stopSend = 0;

	public BlackHole2(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 200, 200, imagePath);
	}

	public void effect(ArrayList<Person> persons) {

		for (int i = 0; i < persons.size(); ++i) {
			Person person = persons.get(i);
		}

	}

}
