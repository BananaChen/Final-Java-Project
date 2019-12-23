package items;

import javax.swing.JPanel;

public abstract class Disturbance extends Items {

	private static final long serialVersionUID = 1L;

	public Disturbance(double x, double y, double vx, double vy, double ax, double ay) {
		super(x, y, vx, vy, ax, ay);
	}
	
	@Override
	public JPanel addLabelToScreen(JPanel panel) {
		panel.add(this.lb);
		return panel;
	}
	
	public abstract boolean hasContactWithPerson(Person person);
	
}