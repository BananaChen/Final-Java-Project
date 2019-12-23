package items;

import java.util.ArrayList;

import javax.swing.JPanel;

import windows.Scene;

public abstract class Aircraft extends Items {
	private static final long serialVersionUID = 1L;

	public Aircraft(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		
	}
	
	public void relocatePositionIfNeed() {
		if (getPositionX() > Scene.bgWidth) {
			setPositionX(-imageWidth);
		}
	}
	
	@Override
	public JPanel addLabelToScreen(JPanel panel) {
		panel.add(this.getLabel());
		return panel;
	}
}