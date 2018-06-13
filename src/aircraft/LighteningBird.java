package aircraft;

import items.*;

public class LighteningBird extends Aircraft{

	public LighteningBird(int x, int y) {
		super(x, y, 3, Math.sin(x), 0, 0);
	}
	
	public LighteningBird(int x, int y, int vx, int vy, int ax, int ay) {
		super(x, y, vx, vy, ax, ay);
	}
	
	public void trace() {
		
	}
}
