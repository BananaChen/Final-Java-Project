package windows;

import items.*;
import person.*;
import aircraft.*;
import destination.*;
import disturbance.*;


import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;

public class Stage5 extends Scene implements ActionListener {

	// Container c;
	public double bloodX;
	public double bloodY;

	public ArrayList<Disturbance> fireballs;

	public Stage5() {

		super();

		// declare concrete factory
		factory = new Stage5Factory();
		
		addElementToPanel(factory);

		// set background
		bgImagePath = "https://i.imgur.com/ntB2uDf.png";
		setWindow(bgImagePath);
		
		// start timer
		startTimer();
	}



	@Override
	public Scene getCurrentStage() {
		return new Stage5();
	}

	@Override
	public Scene getNextStage() {
		return new EndScene();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		performAction(true);
	}

}