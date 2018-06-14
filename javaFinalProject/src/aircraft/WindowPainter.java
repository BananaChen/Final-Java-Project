package aircraft;


import items.*;
import windows.Scene;

public class WindowPainter extends Items{
	public WindowPainter(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 150;
		imageHeight = Scene.bgHeight;
		setImage(x, y, imageWidth, imageHeight, "https://i.imgur.com/jTfazs0.png");
	}
	
	public void brush() {
		if (positionX < Scene.bgWidth*2) {
			positionX += 700;
			lb.setLocation((int)positionX, (int)positionY);
		}
	}
}
