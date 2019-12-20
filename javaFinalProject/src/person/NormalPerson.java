package person;

import items.Person;

public class NormalPerson extends Person{

	private static final long serialVersionUID = 1L;

	public NormalPerson(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		setImage(x, y, 100, 100, "https://image.flaticon.com/icons/png/512/72/72924.png");
	}

}
