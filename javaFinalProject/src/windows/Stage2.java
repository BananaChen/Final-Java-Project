package windows;

import items.*;

import java.util.ArrayList;
import java.awt.event.*;


public class Stage2 extends Scene implements ActionListener {

	public double bloodX;
	public double bloodY;
	
	public ArrayList<Disturbance> arrows;

	public Stage2() {
		super();

		factory = new Stage2Factory();
		addElementToPanel(factory);

		bgImagePath = "https://i.imgur.com/dbcQwI3.jpg";
		setWindow(bgImagePath);
		
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
