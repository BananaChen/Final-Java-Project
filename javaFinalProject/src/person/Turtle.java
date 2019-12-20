package person;

import items.*;

public class Turtle extends Person {
	private static final long serialVersionUID = 1L;

    public Turtle(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
        super(x, y, vx, vy, ax, ay);
        setImage(x, y, 100, 100, imagePath);
    }
}
