package windows;

import items.*;

import java.util.ArrayList;
import java.awt.event.*;


public class Stage2 extends Scene implements ActionListener {

	//Container c;
	public double bloodX;
	public double bloodY;
	
	public ArrayList<Disturbance> arrows;

	public Stage2() {
		super();

		// declare concrete factory
		factory = new Stage2Factory();
		
		addElementToPanel(factory);

		// set background
		bgImagePath = "https://i.imgur.com/dbcQwI3.jpg";
		setWindow(bgImagePath);
		
		// start timer
		startTimer();
	}

	
	@Override
	public Scene getCurrentStage() {
		return new Stage2();
	}

	@Override
	public Scene getNextStage() {
		return new Stage3();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		performAction();
	}

}
