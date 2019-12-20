package windows;

import java.awt.event.*;

public class Stage4 extends Scene implements ActionListener {

	public Stage4() {
		
		super();

		// declare concrete factory
		factory = new Stage4Factory();
		
		addElementToPanel(factory);

		// set background
		bgImagePath = "https://i.imgur.com/jrWlbHA.jpg";
		setWindow(bgImagePath);
		
		// start timer
		startTimer();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		performAction();
	}

	@Override
	public Scene getCurrentStage() {
		return new Stage4();
	}

	@Override
	public Scene getNextStage() {
		return new Stage5();
	}

}
