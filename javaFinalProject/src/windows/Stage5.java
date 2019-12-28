package windows;

import items.*;

import java.util.ArrayList;
import java.awt.event.*;

public class Stage5 extends Scene implements ActionListener {

	public double bloodX;
	public double bloodY;

	public ArrayList<Disturbance> fireballs;

	public Stage5() {

		super();

		factory = new Stage5Factory();
		
		addElementToPanel(factory);

		bgImagePath = "https://i.imgur.com/ntB2uDf.png";
		setWindow(bgImagePath);
		
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
		performAction();
	}

}