package aircraft;


import java.util.ArrayList;

import javax.swing.JPanel;

import items.*;
import windows.Scene;

public class WindowPainter extends Items{

	private static final long serialVersionUID = 1L;

	public WindowPainter(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
		imageWidth = 150;
		imageHeight = Scene.bgHeight;
		setImage(x, y, imageWidth, imageHeight, "https://i.imgur.com/jTfazs0.png");
	}
	
	public void brush() {
		if (this.getPositionX() < Scene.bgWidth*2) {
			this.setPositionX(this.getPositionX() + 700);
			this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
		}
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		
	}
	
	@Override
	public JPanel addLabelToScreen(JPanel panel) {
		panel.add(this.getLabel());
		return panel;
	}
}
