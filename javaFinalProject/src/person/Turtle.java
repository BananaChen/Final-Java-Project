package person;

import items.*;

public class Turtle extends Person {
	private String imagePath = "https://i.imgur.com/A05MTnq.gif";

    public Turtle(double x, double y, double vx, double vy, double ax, double ay, String imagePath) {
        super(x, y, vx, vy, ax, ay);
        setImage(x, y, 100, 100, imagePath);
    }
}
