package items;

public abstract class Aircraft extends Items {

	public Aircraft(double x, double y) {
		super(x, y, 0, 0, 0, 0);
	}

	public Aircraft(double x, double y, double vx, double vy) {
		super(x, y, vx, vy, 0, 0);
	}

	public Aircraft(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}
}