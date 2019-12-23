package items;

import java.util.ArrayList;

import javax.swing.JPanel;

import windows.Scene;

public abstract class Person extends Items {
	private static final long serialVersionUID = 1L;
	public boolean isDropped = false;

	public double personInitPx = 0;
	public double personInitPy = 0;
	public double personInitVx = 0;
	public double personInitVy = 0;
	public double personInitAx = 0;
	public double personInitAy = 0;
	
	public int blood = 3;

	public Person() {
		
	}
	
	public Person(double x, double y, double vx, double vy, double ax, double ay) {
		super();
		setInitMoveData(x, y, vx, vy, ax, ay);
	}

	public void setInitMoveData(double x, double y, double vx, double vy, double ax, double ay) {
		personInitVx = vx;
		personInitVy = vy;
		personInitAx = ax;
		personInitAy = ay;
	
	}
	
	@Override
	public void effect(ArrayList<Items> items, Scene currentScene) {
		if (this.isDropped == false) {
			// move with aircraft
			for (Items item : items) {
				if (item instanceof Aircraft) {
					Aircraft aircraft = (Aircraft) item;
					this.personInitPx = aircraft.positionX + aircraft.imageWidth / 2;
					this.personInitPy = aircraft.positionY + aircraft.imageHeight / 2;
					this.setMoveData(this.personInitPx, this.personInitPy, this.personInitVx, this.personInitVy, this.personInitAx, this.personInitAy);
				}
			}
		}
	}

	@Override
	public void move() {
		
		this.velocityX += this.accelerationX;
		this.velocityY += this.accelerationY;
		this.positionX += this.velocityX;
		this.positionY += this.velocityY;
		this.setLabelLocation((int) this.positionX, (int) this.positionY);
	}
	
	@Override
	public JPanel addLabelToScreen(JPanel panel) {
		panel.add(this.getLabel());
		return panel;
	}
	
	public void parachute() {
		System.out.println("parachute!");
		if (this.isDropped)
			return;
		this.isDropped = true;
		this.setLabelVisibility(true);
		this.setLabelLocation((int) this.getPositionX(), (int) this.getPositionY());
	}
}