package aircraft;

import items.*;
import windows.Scene;

public class WindowPainter extends Items{
	public WindowPainter(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 150;
		imageHeight = Scene.bgHeight;
		setImage(x, y, imageWidth, imageHeight, "https://i.imgur.com/9HrrZCt.png");
	}
	
	public void brush() {
		if (positionX < Scene.bgWidth) {
			positionX += 700;
			lb.setLocation((int)positionX, (int)positionY);
		}
	}
}
