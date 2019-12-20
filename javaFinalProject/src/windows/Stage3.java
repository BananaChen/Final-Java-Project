package windows;

import java.awt.event.*;

public class Stage3 extends Scene implements ActionListener {
	
	public Stage3() {
		
		super();
		
		// declare concrete factory
		factory = new Stage3Factory();
		
		addElementToPanel(factory);
		
		
		// set background
		bgImagePath = "https://i.imgur.com/pLHkh4G.jpg";
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
		return new Stage3();
	}

	@Override
	public Scene getNextStage() {
		return new Stage4();
	}

}
